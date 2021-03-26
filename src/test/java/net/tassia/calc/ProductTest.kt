package net.tassia.calc

import kotlin.random.Random

object ProductTest {

	private fun testProduct(a: Double, b: Double) {
		val expect = a * b
		val actual = (a.calc() * b.calc()).evaluateDouble()
		if (actual != expect) throw Tests.Failure("Multiplication", "$a * $b", expect, actual)
	}

	private fun testProduct(a: Long, b: Long) {
		val expect = a * b
		val actual = (a.calc() * b.calc()).evaluateLong()
		if (actual != expect) throw Tests.Failure("Multiplication", "$a * $b", expect, actual)
	}

	fun testDouble(iterations: Int) {
		repeat(iterations) { testProduct(Random.nextDouble(), Random.nextDouble()) }
	}

	fun testLong(iterations: Int) {
		repeat(iterations) { testProduct(Random.nextLong(), Random.nextLong()) }
	}

}
