package net.tassia.calculator.parser;

import net.tassia.calculator.value.NumericValue;

public interface ExpressionParser {

	NumericValue parse(String input) throws ParseException;

}
