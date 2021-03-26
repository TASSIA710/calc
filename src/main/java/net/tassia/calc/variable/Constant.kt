package net.tassia.calc.variable

import net.tassia.calc.ICalculatable
import net.tassia.calc.MathException

/**
 * A constant is a [Variable] whose value may never be updated.
 *
 * @param name the name of the constant
 * @param value the value of the constant
 *
 * @since Calc 1.0
 * @author Tassilo
 */
class Constant(name: String, private val value: ICalculatable) : Variable(name) {

	override fun get(): ICalculatable = value

	override fun set(value: ICalculatable) = throw MathException("Variable $name is constant and cannot be re-assigned.")

}
