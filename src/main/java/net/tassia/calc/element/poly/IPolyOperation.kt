package net.tassia.calc.element.poly

import net.tassia.calc.ICalculatable

/**
 * A poly operation is an operation with `n` operands.
 *
 * @since Calc 1.0
 * @author Tassilo
 */
interface IPolyOperation {

	/**
	 * The operands.
	 */
	val operands: Collection<ICalculatable>

}
