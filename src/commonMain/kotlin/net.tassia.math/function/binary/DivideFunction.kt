package net.tassia.math.function.binary

import net.tassia.math.Calculatable
import net.tassia.math.function.BinaryFunction
import net.tassia.math.function.FunctionMeta
import net.tassia.math.function.FunctionType
import net.tassia.math.function.PolyFunction
import net.tassia.math.function.poly.AddFunction

class DivideFunction(leftHand: Calculatable, rightHand: Calculatable) : BinaryFunction(leftHand, rightHand, Companion) {

	override fun compareTo(other: Calculatable): Int {
		TODO("Not yet implemented")
	}



	override val isPositive: Boolean by lazy {
		leftHand.isPositive && rightHand.isPositive || leftHand.isNegative && rightHand.isNegative
	}

	override val isNegative: Boolean by lazy { !isZero && !isPositive }

	override val isZero: Boolean by lazy { leftHand.isZero }



	companion object : FunctionMeta (
		name = "Division",
		symbol = "/",
		type = FunctionType.BINARY,
	)

}
