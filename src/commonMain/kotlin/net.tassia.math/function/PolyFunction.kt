package net.tassia.math.function

import net.tassia.math.Calculatable

abstract class PolyFunction (

	val operands: List<Calculatable>,
	meta: FunctionMeta,

) : Function(meta) {

	init {
		require(meta.type == FunctionType.POLY)
	}

	override fun hashCode(): Int {
		var hash = meta.hashCode()
		for (operand in operands) {
			hash = 31 * hash + operand.hashCode()
		}
		return hash
	}

	override fun toString(): String {
		return meta.symbol + "(" + operands.joinToString(", ") + ")"
	}

}
