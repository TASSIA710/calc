package net.tassia.calc

import kotlin.random.Random

object SumTest {

	private fun testSum(a: Double, b: Double) {
		val expect = a + b
		val actual = (a.calc() + b.calc()).evaluateDouble()
		if (actual != expect) throw Tests.Failure("Sum", "$a + $b", expect, actual)
	}

	private fun testSum(a: Long, b: Long) {
		val expect = a + b
		val actual = (a.calc() + b.calc()).evaluateLong()
		if (actual != expect) throw Tests.Failure("Sum", "$a + $b", expect, actual)
	}

	fun testDouble(iterations: Int) {
		repeat(iterations) { testSum(Random.nextDouble(), Random.nextDouble()) }
	}

	fun testLong(iterations: Int) {
		repeat(iterations) { testSum(Random.nextLong(), Random.nextLong()) }
	}

}
