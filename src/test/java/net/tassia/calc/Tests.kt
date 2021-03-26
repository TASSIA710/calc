package net.tassia.calc

import kotlin.test.assertEquals
import kotlin.test.Test

const val ITERATIONS_FAST = 4096 * 4096

class Tests {

	@Test
	fun test1() {
		val a = 2.calc(); val b = 4.calc(); val c = 8.calc()

		val result1 = (a + b) * c
		assertEquals((2 + 4) * 8.0, result1())

		val result2 = a * (b + c)
		assertEquals(2.0 * (4 + 8), result2())
	}



	@Test
	fun testProductLong() = ProductTest.testLong(ITERATIONS_FAST)

	@Test
	fun testProductDouble() = ProductTest.testDouble(ITERATIONS_FAST)



	@Test
	fun testRemainderLong() = RemainderTest.testLong(ITERATIONS_FAST)

	@Test
	fun testRemainderDouble() = RemainderTest.testDouble(ITERATIONS_FAST)



	@Test
	fun testSumLong() = SumTest.testLong(ITERATIONS_FAST)

	@Test
	fun testSumDouble() = SumTest.testDouble(ITERATIONS_FAST)



	class Failure(name: String, current: Any, expect: Any, actual: Any) : AssertionError(
		"$name failed for $current - expected: $expect; actual: $actual"
	)

}
