package net.tassia.calc

/**
 * Base for essentially every element of this library.
 *
 * @since Calc 1.0
 * @author Tassilo
 */
interface ICalculatable {

	operator fun plus(other: ICalculatable): ICalculatable
	operator fun minus(other: ICalculatable): ICalculatable
	operator fun times(other: ICalculatable): ICalculatable
	operator fun div(other: ICalculatable): ICalculatable
	operator fun rem(other: ICalculatable): ICalculatable
	// TODO: RangeTo

	operator fun unaryPlus(): ICalculatable = this
	operator fun unaryMinus(): ICalculatable

	operator fun inc(): ICalculatable
	operator fun dec(): ICalculatable

	operator fun compareTo(other: ICalculatable): Int



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
