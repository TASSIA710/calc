package net.tassia.math.function.binary

import net.tassia.math.Calculatable
import net.tassia.math.function.BinaryFunction
import net.tassia.math.function.FunctionMeta
import net.tassia.math.function.FunctionType

class PowerFunction(leftHand: Calculatable, rightHand: Calculatable) : BinaryFunction(leftHand, rightHand, Companion) {

	override fun compareTo(other: Calculatable): Int {
		TODO("Not yet implemented")
	}



	override val isPositive: Boolean by lazy {
		if (leftHand.isPositive) return@lazy true
		// TODO
		return@lazy false
	}

	override val isNegative: Boolean by lazy {
		// TODO
		return@lazy false
	}

	override val isZero: Boolean by lazy {
		// TODO
		return@lazy false
	}



	companion object : FunctionMeta (
		name = "Power",
		symbol = "pow",
		type = FunctionType.BINARY,
	)

}
