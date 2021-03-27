package net.tassia.calc.element

import net.tassia.calc.ICalculatable
import net.tassia.calc.variable.Variable

/**
 * Represents a call to a variable.
 *
 * @param variable the called variable
 *
 * @since Calc 1.0
 * @author Tassilo
 */
class VariableCall(val variable: Variable) : ICalculatable {

	override fun toFunctionString(): String = variable.name

	override fun evaluateDouble(): Double = variable.get().evaluateDouble()

	override fun evaluateLong(): Long = variable.get().evaluateLong()

}
