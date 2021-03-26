package net.tassia.calc.element.binary

import net.tassia.calc.ICalculatable
import net.tassia.calc.element.poly.Sum

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

	override fun plus(other: ICalculatable): ICalculatable = Sum(this, other)

	override fun minus(other: ICalculatable): ICalculatable = plus(-other)

	override fun times(other: ICalculatable): ICalculatable = Fraction(leftHand * other, rightHand)

	override fun div(other: ICalculatable): ICalculatable = Fraction(leftHand, rightHand * other)



	override fun toFunctionString(): String {
		return "div(" + leftHand.toFunctionString() + ", " + rightHand.toFunctionString() + ")"
	}



	override fun evaluateDouble(): Double {
		return leftHand.evaluateDouble() / rightHand.evaluateDouble()
	}

}
