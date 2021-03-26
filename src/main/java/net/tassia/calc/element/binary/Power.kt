package net.tassia.calc.element.binary

import net.tassia.calc.ICalculatable
import net.tassia.calc.Math

/**
 * The power is a binary-operation the raises the left-hand value to the right-hand value.
 *
 * @since Calc 1.0
 * @author Tassilo
 */
class Power(override val leftHand: ICalculatable, override val rightHand: ICalculatable) : IBinaryOperation, ICalculatable {

	override val name: String = "pow"



	override fun evaluateDouble(): Double {
		return Math.pow(leftHand.evaluateDouble(), rightHand.evaluateDouble())
	}

	override fun evaluateLong(): Long {
		return Math.pow(leftHand.evaluateLong(), rightHand.evaluateLong())
	}

}
