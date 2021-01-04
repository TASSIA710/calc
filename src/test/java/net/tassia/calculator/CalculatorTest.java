package net.tassia.calculator;

import net.tassia.calculator.parser.ParseException;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	void calculate() throws ParseException {
		try {
			assert Calculator.calculate("2 * 2") == 4;
		} catch (ParseException ex) {
			System.out.println(ParseException.getDisplayed(ex));
			throw ex;
		}
	}

}