package net.tassia.math.special

import net.tassia.math.Calculatable

sealed class SpecialConstant(private val name: String, private val hash: Int) : Calculatable() {

	override fun toString(): String = name

	override fun hashCode(): Int = hash

	override fun equals(other: Any?): Boolean {
		return this === other
	}

}
