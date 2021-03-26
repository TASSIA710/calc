package net.tassia.calc

import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals

class MathTest {

	@Test
	fun test1() {
		val a = 2.calc(); val b = 4.calc(); val c = 8.calc()

		val result1 = (a + b) * c
		assertEquals((2 + 4) * 8.0, result1())

		val result2 = a * (b + c)
		assertEquals(2.0 * (4 + 8), result2())
	}





	private fun testRemainder(a: Double, b: Double) {
		val expect = a % b
		val actual = (a.calc() % b.calc()).evaluateDouble()
		if (actual != expect) {
			throw AssertionError("Remainder failed for $a % $b - expected: $expect; actual: $actual")
		}
	}

	private fun testRemainder(a: Long, b: Long) {
		val expect = a % b
		val actual = (a.calc() % b.calc()).evaluateLong()
		if (actual != expect) {
			throw AssertionError("Remainder failed for $a % $b - expected: $expect; actual: $actual")
		}
	}

	@Test
	fun testRemaindersRandomDouble() {
		repeat(ITERATIONS_FAST) { testRemainder(Random.nextDouble(), Random.nextDouble()) }
	}

	@Test
	fun testRemaindersRandomLong() {
		repeat(ITERATIONS_FAST) { testRemainder(Random.nextLong(), Random.nextLong()) }
	}





	private fun testProduct(a: Double, b: Double) {
		val expect = a * b
		val actual = (a.calc() * b.calc()).evaluateDouble()
		if (actual != expect) {
			throw AssertionError("Multiplication failed for $a * $b - expected: $expect; actual: $actual")
		}
	}

	private fun testProduct(a: Long, b: Long) {
		val expect = a * b
		val actual = (a.calc() * b.calc()).evaluateLong()
		if (actual != expect) {
			throw AssertionError("Multiplication failed for $a * $b - expected: $expect; actual: $actual")
		}
	}

	@Test
	fun testProductsRandomDouble() {
		repeat(ITERATIONS_FAST) { testProduct(Random.nextDouble(), Random.nextDouble()) }
	}

	@Test
	fun testProductsRandomLong() {
		repeat(ITERATIONS_FAST) { testProduct(Random.nextLong(), Random.nextLong()) }
	}





	private fun testSum(a: Double, b: Double) {
		val expect = a + b
		val actual = (a.calc() + b.calc()).evaluateDouble()
		if (actual != expect) {
			throw AssertionError("Sum failed for $a + $b - expected: $expect; actual: $actual")
		}
	}

	private fun testSum(a: Long, b: Long) {
		val expect = a + b
		val actual = (a.calc() + b.calc()).evaluateLong()
		if (actual != expect) {
			throw AssertionError("Sum failed for $a + $b - expected: $expect; actual: $actual")
		}
	}

	@Test
	fun testSumsRandomDouble() {
		repeat(ITERATIONS_FAST) { testSum(Random.nextDouble(), Random.nextDouble()) }
	}

	@Test
	fun testSumsRandomLong() {
		repeat(ITERATIONS_FAST) { testSum(Random.nextLong(), Random.nextLong()) }
	}

}
