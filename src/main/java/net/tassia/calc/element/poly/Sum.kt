package net.tassia.calc.element.poly

import net.tassia.calc.ICalculatable
import net.tassia.calc.function.std.SumFunction

/**
 * A sum is a poly-operation that adds all operands together to produce an output.
 *
 * @param operands the operands
 *
 * @since Calc 1.0
 * @author Tassilo
 */
class Sum(override val operands: Collection<ICalculatable>) : IPolyOperation, ICalculatable {

	constructor(vararg operands: ICalculatable) : this(operands.toList())

	override val name: String = SumFunction.name



	override fun evaluateDouble(): Double {
		var cache = 0.0
		operands.forEach { cache += it.evaluateDouble() }
		return cache
	}

	override fun evaluateLong(): Long {
		var cache = 0L
		operands.forEach { cache += it.evaluateLong() }
		return cache
	}

}
