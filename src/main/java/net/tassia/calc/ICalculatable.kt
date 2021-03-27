package net.tassia.calc

import net.tassia.calc.element.binary.Fraction
import net.tassia.calc.element.binary.Power
import net.tassia.calc.element.binary.Remainder
import net.tassia.calc.element.poly.Product
import net.tassia.calc.element.poly.Sum

/**
 * Base for essentially every element of this library.
 *
 * @since Calc 1.0
 * @author Tassilo
 */
interface ICalculatable : IFunctionString, Comparable<ICalculatable> {

	/**
	 * Adds this element to another element.
	 *
	 * @param other the element to add
	 * @return the addition result
	 */
	operator fun plus(other: ICalculatable): ICalculatable = Sum(this, other)

	/**
	 * Subtracts an element from this element.
	 *
	 * @param other the element to subtract
	 * @return the subtraction result
	 */
	operator fun minus(other: ICalculatable): ICalculatable = plus(-other)

	/**
	 * Multiplies this element with another element.
	 *
	 * @param other the element to multiply with
	 * @return the multiplication result
	 */
	operator fun times(other: ICalculatable): ICalculatable = Product(this, other)

	/**
	 * Divides an element from this element.
	 *
	 * @param other the element to divide with
	 * @return the division result
	 */
	operator fun div(other: ICalculatable): ICalculatable = Fraction(this, other)



	/**
	 * Returns the remainder of this element divided by another one.
	 *
	 * @param other the value to divide with
	 * @return the remainder
	 */
	operator fun rem(other: ICalculatable): ICalculatable = Remainder(this, other)

	/**
	 * Returns this value, raised to the other value.
	 *
	 * @param other the other value
	 * @return the result
	 */
	infix fun pow(other: ICalculatable): ICalculatable = Power(this, other)

	// TODO: RangeTo



	/**
	 * Returns this element.
	 *
	 * @return `this`
	 */
	operator fun unaryPlus(): ICalculatable = this

	/**
	 * Returns a negated version of this element.
	 *
	 * @return this element negated
	 */
	operator fun unaryMinus(): ICalculatable = times((-1).calc())



	/**
	 * Returns this element, incremented by 1.
	 *
	 * @return the incremented value
	 */
	operator fun inc(): ICalculatable = plus(1.calc())

	/**
	 * Returns this element, decremented by 1.
	 *
	 * @return the decremented value
	 */
	operator fun dec(): ICalculatable = minus(1.calc())



	/**
	 * Compares this element to another element.
	 *
	 * @param other the other element
	 * @return the comparison result
	 *
	 * @see Comparable
	 */
	override operator fun compareTo(other: ICalculatable): Int = this.evaluateDouble().compareTo(other.evaluateDouble())



	/**
	 * Tries to simplify this element.
	 *
	 * Example of a case with possible simplification:
	 * `2 + 2` to `4`
	 *
	 * Example of a case with impossible simplification:
	 * `2 * PI`
	 * (Cannot be simplified without precision loss due to rounding of PI)
	 *
	 * @return the simplified element, or `this` if it can't be simplified any further
	 */
	fun simplify(): ICalculatable = TODO()



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

	/**
	 * Evaluates the [Int] value for this element.
	 *
	 * @return the value
	 */
	fun evaluateInt(): Int = evaluateLong().toInt()

	/**
	 * Evaluates the [Long] value for this element.
	 *
	 * @return the value
	 */
	fun evaluateLong(): Long



	/**
	 * Evaluates this element.
	 *
	 * @return the value
	 *
	 * @see [evaluateDouble]
	 */
	operator fun invoke(): Double = evaluateDouble()

}
