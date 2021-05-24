package net.tassia.math.function.poly

import net.tassia.math.Calculatable
import net.tassia.math.function.FunctionMeta
import net.tassia.math.function.FunctionType
import net.tassia.math.function.PolyFunction

class AddFunction(operands: List<Calculatable>) : PolyFunction(operands, Companion) {

	override fun compareTo(other: Calculatable): Int {
		TODO("Not yet implemented")
	}



	override val isPositive: Boolean by lazy {
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
		name = "Addition",
		symbol = "+",
		type = FunctionType.POLY,
	)

}
