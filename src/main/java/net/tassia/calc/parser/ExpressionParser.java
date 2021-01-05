package net.tassia.calc.parser;

import net.tassia.calc.value.NumericValue;

/**
 * Implementing classes can parse input terms into a numeric value.
 * @author Tassilo
 * @since Calc 1.0
 */
public interface ExpressionParser {

	/**
	 * Parses the given term into a numeric value.
	 * @param term the term
	 * @return the numeric value
	 * @throws ParseException if the string doesn't fit the term grammar
	 */
	NumericValue parse(String term) throws ParseException;

}
