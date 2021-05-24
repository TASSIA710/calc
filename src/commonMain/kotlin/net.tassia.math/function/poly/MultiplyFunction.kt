package net.tassia.math.function.poly

import net.tassia.math.Calculatable
import net.tassia.math.function.FunctionMeta
import net.tassia.math.function.FunctionType
import net.tassia.math.function.PolyFunction

class MultiplyFunction(operands: List<Calculatable>) : PolyFunction(operands, Companion) {

	override fun compareTo(other: Calculatable): Int {
		TODO("Not yet implemented")
	}



	override val isPositive: Boolean by lazy {
		if (isZero) return@lazy false
		var positive = true
		for (operand in operands) {
			positive = if (positive) {
				operand.isPositive
			} else {
				operand.isNegative
			}
		}
		return@lazy positive
	}

	override val isNegative: Boolean by lazy { !isZero && !isPositive }

	override val isZero: Boolean by lazy {
		for (operand in operands) {
			if (operand.isZero) return@lazy true
		}
		return@lazy false
	}



	companion object : FunctionMeta (
		name = "Multiplication",
		symbol = "*",
		type = FunctionType.POLY,
	)

}
