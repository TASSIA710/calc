package net.tassia.calc.element

import net.tassia.calc.ICalculatable
import net.tassia.calc.element.binary.Fraction
import net.tassia.calc.element.poly.Product
import net.tassia.calc.element.poly.Sum
import net.tassia.calc.function.Function

/**
 * Represents a call to a function.
 *
 * @param function the called function
 * @param args the arguments
 *
 * @since Calc 1.0
 * @author Tassilo
 */
class FunctionCall(val function: Function, val args: List<ICalculatable>) : ICalculatable {

	override fun plus(other: ICalculatable): ICalculatable = Sum(this, other)

	override fun minus(other: ICalculatable): ICalculatable = plus(-other)

	override fun times(other: ICalculatable): ICalculatable = Product(this, other)

	override fun div(other: ICalculatable): ICalculatable = Fraction(this, other)



	override fun toFunctionString(): String {
		return function.name + "(" + args.joinToString(transform = ICalculatable::toFunctionString) + ")"
	}



	override fun evaluateDouble(): Double {
		return function(args).evaluateDouble()
	}

}
