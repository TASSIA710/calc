package net.tassia.math.function.unary

import net.tassia.math.Calculatable
import net.tassia.math.function.*

class CubeRootFunction(operand: Calculatable) : UnaryFunction(operand, Companion) {

	override fun compareTo(other: Calculatable): Int {
		TODO("Not yet implemented")
	}



	override val isPositive: Boolean by lazy { operand.isPositive }

	override val isNegative: Boolean by lazy { operand.isNegative }

	override val isZero: Boolean by lazy { operand.isZero }



	companion object : FunctionMeta (
		name = "Cube Root",
		symbol = "cbrt",
		type = FunctionType.UNARY,
	)

}
