package net.tassia.calc.element

import net.tassia.calc.ICalculatable
import net.tassia.calc.element.binary.Fraction
import net.tassia.calc.element.poly.Product
import net.tassia.calc.element.poly.Sum

/**
 * Represents a decimal value. A decimal value is an integer, combined with a fractal part (e.g. `2.75`).
 *
 * **Note:** You shouldn't use this for irrational numbers or numbers with repeating decimals. Instead a
 * [Fraction] or just a constant should be used.
 *
 * @param value the value
 *
 * @since Calc 1.0
 * @author Tassilo
 */
class Decimal(val value: Double) : ICalculatable {

	override fun plus(other: ICalculatable): ICalculatable = Sum(this, other)

	override fun minus(other: ICalculatable): ICalculatable = plus(-other)

	override fun times(other: ICalculatable): ICalculatable = Product(this, other)

	override fun div(other: ICalculatable): ICalculatable = Fraction(this, other)



	override fun toFunctionString(): String = value.toString()

	override fun evaluateDouble(): Double = value

	override fun evaluateLong(): Long = value.toLong()

}
