package net.tassia.math.constant

import net.tassia.math.Calculatable
import net.tassia.math.implementation.Integer

object Constants {

	val ZERO = IntegerConstant(Integer.ZERO)
	val ONE = IntegerConstant(Integer.ONE)
	val TWO = IntegerConstant(Integer.TWO)
	val NEGATIVE_ONE = IntegerConstant(-Integer.ONE)



	object PI : IrrationalConstant("π") {

		override fun compareTo(other: Calculatable): Int {
			TODO("Not yet implemented")
		}

		override val isPositive: Boolean = true
		override val isZero: Boolean = false
		override val isNegative: Boolean = false

	}

	object E : IrrationalConstant("e") {

		override fun compareTo(other: Calculatable): Int {
			TODO("Not yet implemented")
		}

		override val isPositive: Boolean = true
		override val isZero: Boolean = false
		override val isNegative: Boolean = false

	}

}
