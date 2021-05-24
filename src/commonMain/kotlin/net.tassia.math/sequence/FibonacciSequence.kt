package net.tassia.math.sequence

import net.tassia.math.Calculatable
import net.tassia.math.constant.Constants

class FibonacciSequence (

	private val f0: Calculatable = Constants.TWO,
	private val f1: Calculatable = Constants.ONE,

) : Sequence<Calculatable> {

	override fun iterator(): Iterator<Calculatable> {
		return FibonacciIterator(f0, f1)
	}

}
