package net.tassia.calc.element.binary

import net.tassia.calc.ICalculatable
import net.tassia.calc.IFunctionString

/**
 * A binary operation is an operation with two operands.
 *
 * @since Calc 1.0
 * @author Tassilo
 */
interface IBinaryOperation : IFunctionString {

	/**
	 * The left-hand operand.
	 */
	val leftHand: ICalculatable

	/**
	 * The right-hand operand.
	 */
	val rightHand: ICalculatable



	val name: String

	override fun toFunctionString(): String {
		return name + "(" + leftHand.toFunctionString() + ", " + rightHand.toFunctionString() + ")"
	}

}
