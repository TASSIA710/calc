package net.tassia.calc.element.poly

import net.tassia.calc.ICalculatable
import net.tassia.calc.IFunctionString

/**
 * A poly operation is an operation with `n` operands.
 *
 * @since Calc 1.0
 * @author Tassilo
 */
interface IPolyOperation : IFunctionString {

	/**
	 * The operands.
	 */
	val operands: Collection<ICalculatable>



	val name: String

	override fun toFunctionString(): String {
		return name + "(" + operands.joinToString(transform = ICalculatable::toFunctionString) + ")"
	}

}
