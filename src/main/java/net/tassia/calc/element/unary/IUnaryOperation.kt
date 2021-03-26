package net.tassia.calc.element.unary

import net.tassia.calc.ICalculatable
import net.tassia.calc.IFunctionString

/**
 * A unary operation is an operation with one operand.
 *
 * @since Calc 1.0
 * @author Tassilo
 */
interface IUnaryOperation : IFunctionString {

	/**
	 * The operand.
	 */
	val operand: ICalculatable



	val name: String

	override fun toFunctionString(): String {
		return name + "(" + operand.toFunctionString() + ")"
	}

}
