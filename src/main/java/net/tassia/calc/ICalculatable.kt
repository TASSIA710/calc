package net.tassia.calc

/**
 * Defines that something can be evaluated into an actual [Double] value.
 *
 * @since Calc 1.0
 * @author Tassilo
 */
interface ICalculatable {

	/**
	 * Evaluates the [Double] value for this element.
	 *
	 * @return the value
	 */
	fun evaluate(): Double

}
