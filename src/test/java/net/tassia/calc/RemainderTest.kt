package net.tassia.calc

import kotlin.random.Random

object RemainderTest {

	private fun testRemainder(a: Double, b: Double) {
		val expect = a % b
		val actual = (a.calc() % b.calc()).evaluateDouble()
		if (actual != expect) throw Tests.Failure("Remainder", "$a % $b", expect, actual)
	}

	private fun testRemainder(a: Long, b: Long) {
		val expect = a % b
		val actual = (a.calc() % b.calc()).evaluateLong()
		if (actual != expect) throw Tests.Failure("Remainder", "$a % $b", expect, actual)
	}

	fun testDouble(iterations: Int) {
		repeat(iterations) { testRemainder(Random.nextDouble(), Random.nextDouble()) }
	}

	fun testLong(iterations: Int) {
		repeat(iterations) { testRemainder(Random.nextLong(), Random.nextLong()) }
	}

}
