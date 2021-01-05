package net.tassia.calc.parser;

import net.tassia.calc.value.NumericValue;

public interface ExpressionParser {

	NumericValue parse(String input) throws ParseException;

}
