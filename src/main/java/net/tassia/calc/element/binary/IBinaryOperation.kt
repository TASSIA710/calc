package net.tassia.calc.element.binary

import net.tassia.calc.ICalculatable

/**
 * A binary operation is an operation with two operands.
 *
 * @since Calc 1.0
 * @author Tassilo
 *
 * @see net.tassia.calc.element.poly.IPolyOperation
 */
interface IBinaryOperation {

	/**
	 * The left-hand operand.
	 */
	val leftHand: ICalculatable

	/**
	 * The right-hand operand.
	 */
	val rightHand: ICalculatable

}
