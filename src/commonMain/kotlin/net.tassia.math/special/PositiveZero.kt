package net.tassia.math.special

import net.tassia.math.Calculatable

object PositiveZero : SpecialConstant("+0", 1) {

	override fun compareTo(other: Calculatable): Int {
		if (other === PositiveZero) return 0
		return if (other.isPositive) -1 else 1
	}

	override val isPositive: Boolean = true
	override val isZero: Boolean = false
	override val isNegative: Boolean = false

}
