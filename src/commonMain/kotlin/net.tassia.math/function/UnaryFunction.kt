package net.tassia.math.function

import net.tassia.math.Calculatable

abstract class UnaryFunction (

	val operand: Calculatable,
	meta: FunctionMeta,

) : Function(meta) {

	init {
		require(meta.type == FunctionType.UNARY)
	}

	override fun hashCode(): Int {
		var hash = meta.hashCode()
		hash = 31 * hash + operand.hashCode()
		return hash
	}

	override fun toString(): String {
		return meta.symbol + "($operand)"
	}

}
