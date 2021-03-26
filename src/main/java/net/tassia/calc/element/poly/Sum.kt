package net.tassia.calc.element.poly

import net.tassia.calc.ICalculatable
import net.tassia.calc.element.binary.Fraction
import net.tassia.calc.merge

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



	override fun plus(other: ICalculatable): ICalculatable = Sum(operands.merge(other))

	override fun minus(other: ICalculatable): ICalculatable = plus(-other)

	override fun times(other: ICalculatable): ICalculatable = Product(this, other)

	override fun div(other: ICalculatable): ICalculatable = Fraction(this, other)



	override fun toFunctionString(): String {
		return "add(" + operands.joinToString(transform = ICalculatable::toFunctionString) + ")"
	}



	override fun evaluateDouble(): Double {
		var cache = 0.0
		operands.forEach { cache += it.evaluateDouble() }
		return cache
	}

}
