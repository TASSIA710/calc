package net.tassia.calc

/**
 * Defines that something can be evaluated into an actual [Double] value.
 *
 * @since Calc 1.0
 * @author Tassilo
 */
interface ICalculatable {

	/**
	 * Evaluates the [Float] value for this element.
	 *
	 * @return the value
	 */
	fun evaluateFloat(): Float = evaluateDouble().toFloat()

	/**
	 * Evaluates the [Double] value for this element.
	 *
	 * @return the value
	 */
	fun evaluateDouble(): Double

}
