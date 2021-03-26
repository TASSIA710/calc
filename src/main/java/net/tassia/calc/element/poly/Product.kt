package net.tassia.calc.element.poly

import net.tassia.calc.ICalculatable
import net.tassia.calc.calc
import net.tassia.calc.element.binary.Fraction
import net.tassia.calc.merge

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



	override fun plus(other: ICalculatable): ICalculatable = Sum(this, other)

	override fun minus(other: ICalculatable): ICalculatable = plus(-other)

	override fun times(other: ICalculatable): ICalculatable = Product(operands.merge(other))

	override fun div(other: ICalculatable): ICalculatable = times(Fraction(1.calc(), other))



	override fun toFunctionString(): String {
		return "mul(" + operands.joinToString(transform = ICalculatable::toFunctionString) + ")"
	}



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
