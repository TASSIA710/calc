package net.tassia.calc.element

import net.tassia.calc.ICalculatable
import net.tassia.calc.element.binary.Fraction
import net.tassia.calc.element.poly.Product
import net.tassia.calc.element.poly.Sum

/**
 * Represents an integer, ranging from essentially negative infinity to positive infinity
 * (although technically limited to `-2^63` to `2^63-1` in this implementation).
 *
 * @param value the value
 *
 * @since Calc 1.0
 * @author Tassilo
 */
class Integer(val value: Long) : ICalculatable {

	override fun plus(other: ICalculatable): ICalculatable = Sum(this, other)

	override fun minus(other: ICalculatable): ICalculatable = plus(-other)

	override fun times(other: ICalculatable): ICalculatable = Product(this, other)

	override fun div(other: ICalculatable): ICalculatable = Fraction(this, other)



	override fun toFunctionString(): String = value.toString()

	override fun evaluateDouble(): Double = value.toDouble()

}
