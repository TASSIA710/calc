package net.tassia.calculator.parser;

import net.tassia.calculator.Operator;
import net.tassia.calculator.value.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class DefaultExpressionParser implements ExpressionParser {

	private static final char EOF = (char) -1;
	private String input;
	private int position;

	@Override
	public NumericValue parse(String input) throws ParseException {
		this.input = input;
		this.position = 0;
		return readExpression();
	}



	private String readMatching(String name, Predicate<Character> predicate) throws ParseException {
		if (predicate.test(peek())) {
			return String.valueOf(next());
		} else {
			throw expected(name);
		}
	}

	private <T> T readOnce(TokenReaderFunction<T> function) throws ParseException {
		return function.read();
	}

	private <T> T readOptional(TokenReaderFunction<T> function) {
		try {
			return function.read();
		} catch (ParseException ex) {
			return null;
		}
	}

	private <T> List<T> readMultiple(TokenReaderFunction<T> function) throws ParseException {
		List<T> list = new ArrayList<>();
		list.add(function.read());
		while (true) {
			try {
				list.add(function.read());
			} catch (ParseException ex) {
				break;
			}
		}
		return list;
	}

	private <T> List<T> readAny(TokenReaderFunction<T> function) {
		List<T> list = new ArrayList<>();
		while (true) {
			try {
				list.add(function.read());
			} catch (ParseException ex) {
				break;
			}
		}
		return list;
	}



	private TokenReaderFunction<String> readCharacterFunction(char c) {
		return () -> {
			if (peek() == c) {
				return String.valueOf(next());
			} else {
				throw expected(String.valueOf(c));
			}
		};
	}

	@SafeVarargs
	private final <T> TokenReaderFunction<T> union(String[] names, TokenReaderFunction<T>...functions) {
		return () -> {
			for (TokenReaderFunction<T> function : functions) {
				try {
					return function.read();
				} catch (ParseException ignored) {
				}
			}
			throw expected(names);
		};
	}



	@TokenReader("WHITE_SPACE")
	private String readWhiteSpace() throws ParseException {
		return readMatching("WHITE_SPACE", Character::isWhitespace);
	}

	@TokenReader("DIGIT")
	private String readDigit() throws ParseException {
		return readMatching("DIGIT", Character::isDigit);
	}

	@TokenReader("LETTER")
	private String readLetter() throws ParseException {
		return readMatching("LETTER", Character::isLetter);
	}



	@TokenReader("EXPRESSION")
	private NumericValue readExpression() throws ParseException {
		readAny(this::readWhiteSpace);
		NumericValue value = readSum();
		readAny(this::readWhiteSpace);
		return value;
	}

	@TokenReader("IDENTIFIER")
	private String readIdentifier() throws ParseException {
		StringBuilder str = new StringBuilder(readOnce(union(new String[]{
				"LETTER", "_"
		}, this::readLetter, readCharacterFunction('_'))));
		List<String> parts = readAny(union(new String[] {
				"LETTER", "_", "DIGIT"
		}, this::readLetter, readCharacterFunction('_'), this::readDigit));
		for (String part : parts) {
			str.append(part);
		}
		return str.toString();
	}

	@TokenReader("SUM")
	private PolyValue readSum() throws ParseException {
		List<NumericValue> elements = new ArrayList<>();
		elements.add(readProduct());
		elements.addAll(readAny(this::readSumPart));
		return new PolyValue(Operator.Poly.ADDITION, elements.toArray(new NumericValue[0]));
	}

	@TokenReader("SUM_PART")
	private NumericValue readSumPart() throws ParseException {
		readAny(this::readWhiteSpace);
		String operator = readOnce(union(new String[] {
				"+", "-"
		}, readCharacterFunction('+'), readCharacterFunction('-')));
		readAny(this::readWhiteSpace);
		NumericValue value = readProduct();
		if (operator.equals("-")) {
			value = new UnaryValue(Operator.Unary.NEGATION, value);
		}
		return value;
	}

	@TokenReader("PRODUCT")
	private PolyValue readProduct() throws ParseException {
		List<NumericValue> elements = new ArrayList<>();
		elements.add(readValue());
		elements.addAll(readAny(this::readProductPart));
		return new PolyValue(Operator.Poly.MULTIPLICATION, elements.toArray(new NumericValue[0]));
	}

	@TokenReader("PRODUCT_PART")
	private NumericValue readProductPart() throws ParseException {
		readAny(this::readWhiteSpace);
		String operator = readOnce(union(new String[] {
				"*", "/"
		}, readCharacterFunction('*'), readCharacterFunction('/')));
		readAny(this::readWhiteSpace);
		NumericValue value = readValue();
		if (operator.equals("/")) {
			value = new Fraction(new ConstantValue(1D), value);
		}
		return value;
	}

	@TokenReader("VALUE")
	private NumericValue readValue() throws ParseException {
		String sign = readOptional(readCharacterFunction('-'));
		readAny(this::readWhiteSpace);
		NumericValue value = readOnce(union(new String[] {
				"GROUPED", "NUMBER", "FUNCTION_CALL", "VARIABLE_CALL"
		}, this::readGrouped, this::readNumber, this::readFunctionCall, this::readVariableCall));
		if (sign != null) {
			value = new UnaryValue(Operator.Unary.NEGATION, value);
		}
		return value;
	}

	@TokenReader("GROUPED")
	private NumericValue readGrouped() throws ParseException {
		readOnce(readCharacterFunction('('));
		NumericValue value = readExpression();
		readOnce(readCharacterFunction(')'));
		return value;
	}

	@TokenReader("NUMBER")
	private ConstantValue readNumber() throws ParseException {
		String[] digit = readMultiple(this::readDigit).toArray(new String[0]);
		String floatingPart = readOptional(this::readNumberFloatingPart);
		String ePart = readOptional(this::readNumberEPart);
		String full = String.join("", digit) + (floatingPart != null ? floatingPart : "") + (ePart != null ? ePart : "");
		try {
			double value = Double.parseDouble(full);
			return new ConstantValue(value);
		} catch (NumberFormatException ex) {
			throw new ParseException(input, position - full.length(), full.length(), "Failed to parse number: " + full, ex);
		}
	}

	@TokenReader("NUMBER_FLOATING_PART")
	private String readNumberFloatingPart() throws ParseException {
		String str = readOnce(readCharacterFunction('.'));
		String[] digit = readMultiple(this::readDigit).toArray(new String[0]);
		return str + String.join("", digit);
	}

	@TokenReader("NUMBER_E_PART")
	private String readNumberEPart() throws ParseException {
		String e = readOnce(union(new String[] {
				"E", "e"
		}, readCharacterFunction('E'), readCharacterFunction('e')));
		String sign = readOptional(union(new String[] {
				"+", "-"
		}, readCharacterFunction('+'), readCharacterFunction('-')));
		String[] digit = readMultiple(this::readDigit).toArray(new String[0]);
		return e + (sign != null ? sign : "+") + String.join("", digit);
	}

	@TokenReader("VARIABLE_CALL")
	private VariableCall readVariableCall() throws ParseException {
		return new VariableCall(readIdentifier());
	}

	@TokenReader("FUNCTION_CALL")
	private FunctionCall readFunctionCall() throws ParseException {
		String identifier = readIdentifier();
		readAny(this::readWhiteSpace);
		readOnce(readCharacterFunction('('));
		readAny(this::readWhiteSpace);
		List<NumericValue> parameters = readOptional(this::readFunctionCallParameters);
		if (parameters == null) parameters = new ArrayList<>();
		readAny(this::readWhiteSpace);
		readOnce(readCharacterFunction(')'));
		return new FunctionCall(identifier, parameters.toArray(new NumericValue[0]));
	}

	@TokenReader("FUNCTION_CALL_PARAMETERS")
	private List<NumericValue> readFunctionCallParameters() throws ParseException {
		List<NumericValue> values = new ArrayList<>();
		values.add(readOnce(this::readFunctionCallParameter));
		values.addAll(readAny(this::readFunctionCallParameter2));
		return values;
	}

	@TokenReader("FUNCTION_CALL_PARAMETER")
	private NumericValue readFunctionCallParameter() throws ParseException {
		return readExpression();
	}

	@TokenReader("FUNCTION_CALL_PARAMETER2")
	private NumericValue readFunctionCallParameter2() throws ParseException {
		readOnce(readCharacterFunction(','));
		return readExpression();
	}



	private char peek() {
		if (position >= input.length()) return EOF;
		return input.charAt(position);
	}

	private char next() {
		char c = peek();
		position++;
		return c;
	}



	private ParseException expected(String...expected) {
		return new ParseException(input, position, 1, "Expected " + String.join(", ", expected));
	}

}
