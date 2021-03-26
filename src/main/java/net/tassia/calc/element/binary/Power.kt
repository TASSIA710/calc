package net.tassia.calc.element.binary

import net.tassia.calc.ICalculatable
import net.tassia.calc.Math

class Power(override val leftHand: ICalculatable, override val rightHand: ICalculatable) : IBinaryOperation, ICalculatable {

	override val name: String = "pow"



	override fun evaluateDouble(): Double {
		return Math.pow(leftHand.evaluateDouble(), rightHand.evaluateDouble())
	}

	override fun evaluateLong(): Long {
		return Math.pow(leftHand.evaluateLong(), rightHand.evaluateLong())
	}

}
