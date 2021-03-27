package net.tassia.calc.element

import net.tassia.calc.ICalculatable

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

	override fun toFunctionString(): String = value.toString()

	override fun evaluateDouble(): Double = value.toDouble()

	override fun evaluateLong(): Long = value

}
