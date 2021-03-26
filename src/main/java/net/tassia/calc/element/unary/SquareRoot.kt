package net.tassia.calc.element.unary

import net.tassia.calc.ICalculatable
import net.tassia.calc.Math
import net.tassia.calc.function.std.SquareRootFunction

/**
 * The square root is a unary-operation that calculates the square root of a given value.
 *
 * @since Calc 1.0
 * @author Tassilo
 */
class SquareRoot(override val operand: ICalculatable) : IUnaryOperation, ICalculatable {

	override val name: String = SquareRootFunction.name



	override fun evaluateDouble(): Double {
		return Math.sqrt(operand.evaluateDouble())
	}

	override fun evaluateLong(): Long {
		return Math.sqrt(operand.evaluateLong().toDouble()).toLong()
	}

}
