package net.tassia.math.function

import net.tassia.math.Calculatable

abstract class BinaryFunction (

	val leftHand: Calculatable,
	val rightHand: Calculatable,
	meta: FunctionMeta,

) : Function(meta) {

	init {
		require(meta.type == FunctionType.BINARY)
	}

	override fun hashCode(): Int {
		var hash = meta.hashCode()
		hash = 31 * hash + leftHand.hashCode()
		hash = 31 * hash + rightHand.hashCode()
		return hash
	}

	override fun toString(): String {
		return meta.symbol + "($leftHand, $rightHand)"
	}

}
