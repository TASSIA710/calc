package net.tassia.calc.element.binary

import net.tassia.calc.ICalculatable
import net.tassia.calc.function.std.FractionFunction

/**
 * A fraction is a binary-operation that divides the right-hand value from the left-hand value.
 * Essentially, it is just a division.
 *
 * @param leftHand the left-hand value, or the numerator
 * @param rightHand the right-hand value, or the denominator
 *
 * @since Calc 1.0
 * @author Tassilo
 */
class Fraction(override val leftHand: ICalculatable, override val rightHand: ICalculatable) : IBinaryOperation, ICalculatable {

	override val name: String = FractionFunction.name



	override fun evaluateDouble(): Double {
		return leftHand.evaluateDouble() / rightHand.evaluateDouble()
	}

	override fun evaluateLong(): Long {
		return leftHand.evaluateLong() / rightHand.evaluateLong()
	}

}
