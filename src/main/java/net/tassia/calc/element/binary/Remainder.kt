package net.tassia.calc.element.binary

import net.tassia.calc.ICalculatable
import net.tassia.calc.function.std.RemainderFunction

/**
 * The remainder is a binary-operation that divides the right-hand value
 * from the left-hand value and determines its remainder.
 *
 * @param leftHand the left-hand value
 * @param rightHand the right-hand value
 *
 * @since Calc 1.0
 * @author Tassilo
 */
class Remainder(override val leftHand: ICalculatable, override val rightHand: ICalculatable) : IBinaryOperation, ICalculatable {

	override val name: String = RemainderFunction.name



	override fun evaluateDouble(): Double {
		return leftHand.evaluateDouble() % rightHand.evaluateDouble()
	}

	override fun evaluateLong(): Long {
		return leftHand.evaluateLong() % rightHand.evaluateLong()
	}

}
