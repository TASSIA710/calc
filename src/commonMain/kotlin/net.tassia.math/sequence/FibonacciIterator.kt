package net.tassia.math.sequence

import net.tassia.math.Calculatable

internal class FibonacciIterator(private var f0: Calculatable, private var f1: Calculatable) : Iterator<Calculatable> {

	override fun hasNext(): Boolean {
		return true
	}

	override fun next(): Calculatable {
		val f2 = f0 + f1
		f0 = f1
		f1 = f2
		return f2
	}

}
