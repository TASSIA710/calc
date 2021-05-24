package net.tassia.math.constant

import net.tassia.math.Calculatable
import net.tassia.math.implementation.Integer

class IntegerConstant(private val value: Integer) : Constant() {

	override fun hashCode(): Int {
		return value.hashCode()
	}

	override fun compareTo(other: Calculatable): Int {
		TODO("Not yet implemented")
	}



	override val isPositive: Boolean by lazy { value.isPositive }

	override val isNegative: Boolean by lazy { value.isNegative }

	override val isZero: Boolean by lazy { value.isZero }



	override fun toString(): String {
		return value.toString()
	}

}
