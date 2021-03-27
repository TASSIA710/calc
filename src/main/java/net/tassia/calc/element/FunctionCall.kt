package net.tassia.calc.element

import net.tassia.calc.ICalculatable
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

	override fun toFunctionString(): String {
		return function.name + "(" + args.joinToString(transform = ICalculatable::toFunctionString) + ")"
	}

	override fun evaluateDouble(): Double {
		return function(args).evaluateDouble()
	}

	override fun evaluateLong(): Long {
		return function(args).evaluateLong()
	}

}
