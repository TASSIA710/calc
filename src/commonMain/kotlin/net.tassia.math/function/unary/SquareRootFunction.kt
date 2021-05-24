package net.tassia.math.function.unary

import net.tassia.math.Calculatable
import net.tassia.math.function.*

class SquareRootFunction(operand: Calculatable) : UnaryFunction(operand, Companion) {

	override fun compareTo(other: Calculatable): Int {
		TODO("Not yet implemented")
	}



	override val isPositive: Boolean by lazy { !isZero }

	override val isNegative: Boolean by lazy { !isZero }

	override val isZero: Boolean by lazy { operand.isZero }



	companion object : FunctionMeta (
		name = "Square Root",
		symbol = "sqrt",
		type = FunctionType.UNARY,
	)

}
