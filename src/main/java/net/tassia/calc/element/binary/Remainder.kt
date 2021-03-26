package net.tassia.calc.element.binary

import net.tassia.calc.ICalculatable
import net.tassia.calc.calc
import net.tassia.calc.element.poly.Product
import net.tassia.calc.element.poly.Sum

/**
 * The remainder if a binary-operation that divides the right-hand value
 * from the left-hand value and determines its remainder.
 *
 * @param leftHand the left-hand value
 * @param rightHand the right-hand value
 *
 * @since Calc 1.0
 * @author Tassilo
 */
class Remainder(override val leftHand: ICalculatable, override val rightHand: ICalculatable) : IBinaryOperation, ICalculatable {

	override fun plus(other: ICalculatable): ICalculatable = Sum(this, other)

	override fun minus(other: ICalculatable): ICalculatable = plus(-other)

	override fun times(other: ICalculatable): ICalculatable = Product(this, other)

	override fun div(other: ICalculatable): ICalculatable = times(Fraction(1.calc(), other))



	override fun toFunctionString(): String {
		return "rem(" + leftHand.toFunctionString() + ", " + rightHand.toFunctionString() + ")"
	}



	override fun evaluateDouble(): Double {
		return leftHand.evaluateDouble() % rightHand.evaluateDouble()
	}

	override fun evaluateLong(): Long {
		return leftHand.evaluateLong() % rightHand.evaluateLong()
	}

}
