package net.tassia.calc.element

import net.tassia.calc.ICalculatable
import net.tassia.calc.element.binary.Fraction
import net.tassia.calc.element.poly.Product
import net.tassia.calc.element.poly.Sum
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

	override fun plus(other: ICalculatable): ICalculatable = Sum(this, other)

	override fun minus(other: ICalculatable): ICalculatable = plus(-other)

	override fun times(other: ICalculatable): ICalculatable = Product(this, other)

	override fun div(other: ICalculatable): ICalculatable = Fraction(this, other)



	override fun toFunctionString(): String = variable.name

	override fun evaluateDouble(): Double = variable.get().evaluateDouble()

}
