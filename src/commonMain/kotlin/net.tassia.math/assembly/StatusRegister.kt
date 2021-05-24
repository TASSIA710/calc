package net.tassia.math.assembly

class StatusRegister(private val state: AssemblyState) {

	val isZero: Boolean
		get() = state.accumulator?.isZero ?: false

	val isNegative: Boolean
		get() = state.accumulator?.isNegative ?: false

	val isPositive: Boolean
		get() = state.accumulator?.isPositive ?: false

}
