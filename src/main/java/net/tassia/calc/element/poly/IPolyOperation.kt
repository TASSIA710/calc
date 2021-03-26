package net.tassia.calc.element.poly

import net.tassia.calc.ICalculatable

/**
 * A poly operation is an operation with `n` (where n >= 0) operands.
 *
 * @since Calc 1.0
 * @author Tassilo
 *
 * @see net.tassia.calc.element.binary.IBinaryOperation
 */
interface IPolyOperation {

	/**
	 * The operands.
	 */
	val elements: Collection<ICalculatable>

}
