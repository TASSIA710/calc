package net.tassia.calc.element.unary

import net.tassia.calc.ICalculatable

/**
 * A unary operation is an operation with one operand.
 *
 * @since Calc 1.0
 * @author Tassilo
 */
interface IUnaryOperation {

	/**
	 * The operand.
	 */
	val operand: ICalculatable

}
