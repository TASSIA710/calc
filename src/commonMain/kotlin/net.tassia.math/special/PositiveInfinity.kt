package net.tassia.math.special

import net.tassia.math.Calculatable

object PositiveInfinity : SpecialConstant("INF", Int.MAX_VALUE) {

	override fun compareTo(other: Calculatable): Int {
		if (other === PositiveInfinity) return 0
		return 1
	}

	override val isPositive: Boolean = true
	override val isZero: Boolean = false
	override val isNegative: Boolean = false

}
