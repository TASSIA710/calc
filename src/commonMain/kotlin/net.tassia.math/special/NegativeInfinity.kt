package net.tassia.math.special

import net.tassia.math.Calculatable

object NegativeInfinity : SpecialConstant("-INF", Int.MIN_VALUE) {

	override fun compareTo(other: Calculatable): Int {
		if (other === NegativeInfinity) return 0
		return -1
	}

	override val isPositive: Boolean = false
	override val isZero: Boolean = false
	override val isNegative: Boolean = true

}
