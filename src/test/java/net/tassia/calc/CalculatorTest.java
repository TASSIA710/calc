package net.tassia.calc;

import net.tassia.calc.parser.ParseException;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	void testExpression(String term, double expect) throws ParseException {
		try {
			double result = Calculator.calculate(term);
			System.out.println(term + " = " + result);
			assert result == expect;
		} catch (ParseException ex) {
			System.out.println(ParseException.getDisplayed(ex));
			throw ex;
		}
	}

	@Test
	void calculate() throws ParseException {
		testExpression("2 + 2", 4);
		testExpression("2 * 2", 4);
		testExpression("max(1, 2, 3, 4, 5)", 5);
		testExpression("min(1, 2, 3, 4, 5)", 1);
	}

}