package net.tassia.math.special

import net.tassia.math.Calculatable

object NegativeZero : SpecialConstant("-0", -1) {

	override fun compareTo(other: Calculatable): Int {
		if (other === NegativeZero) return 0
		return if (other.isNegative) 1 else -1
	}

	override val isPositive: Boolean = false
	override val isZero: Boolean = false
	override val isNegative: Boolean = true

}
