package net.tassia.calc.element.poly

import net.tassia.calc.ICalculatable
import net.tassia.calc.function.std.ProductFunction

/**
 * A product is a poly-operation that multiplies all operands together to produce an output.
 *
 * @param operands the operands
 *
 * @since Calc 1.0
 * @author Tassilo
 */
class Product(override val operands: Collection<ICalculatable>) : IPolyOperation, ICalculatable {

	constructor(vararg operands: ICalculatable) : this(operands.toList())

	override val name: String = ProductFunction.name



	override fun evaluateDouble(): Double {
		var cache = 1.0
		operands.forEach { cache *= it.evaluateDouble() }
		return cache
	}

	override fun evaluateLong(): Long {
		var cache = 1L
		operands.forEach { cache *= it.evaluateLong() }
		return cache
	}

}
