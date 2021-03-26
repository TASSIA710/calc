package net.tassia.calc

/**
 * Defines that an element can be converted to a parsable function string.
 *
 * @since Calc 1.0
 * @author Tassilo
 */
interface IFunctionString {

	/**
	 * Converts this element into an easily parsable function string.
	 *
	 * @return the function string
	 */
	fun toFunctionString(): String

}
