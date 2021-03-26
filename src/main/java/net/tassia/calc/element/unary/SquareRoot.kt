package net.tassia.calc.element.unary

import net.tassia.calc.ICalculatable
import net.tassia.calc.Math

class SquareRoot(override val operand: ICalculatable) : IUnaryOperation, ICalculatable {

	override val name: String = "sqrt"



	override fun evaluateDouble(): Double {
		return Math.sqrt(operand.evaluateDouble())
	}

	override fun evaluateLong(): Long {
		return Math.sqrt(operand.evaluateLong().toDouble()).toLong()
	}

}
