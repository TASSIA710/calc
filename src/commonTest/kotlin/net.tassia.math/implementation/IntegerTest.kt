package net.tassia.math.implementation

import net.tassia.math.ITERATIONS
import kotlin.math.max
import kotlin.random.Random
import kotlin.random.nextUInt
import kotlin.random.nextULong
import kotlin.test.Test
import kotlin.test.assertEquals

class IntegerTest {

	@Test
	fun testHexString() {
		assertEquals("0x00", Integer.ZERO.toHexString())
		assertEquals("0x01", Integer.ONE.toHexString())
		assertEquals("-0x01", (-Integer.ONE).toHexString())
	}





	@Test
	fun testByteConversion() {
		repeat (ITERATIONS) {
			val expect = Random.nextInt().toByte()
			val int = Integer.fromKotlin(expect)
			val actual = int.asByte
			assertEquals(expect, actual)
		}
	}

	@Test
	fun testUByteConversion() {
		repeat (ITERATIONS) {
			val expect = Random.nextInt().toUByte()
			val int = Integer.fromKotlin(expect)
			val actual = int.asUByte
			assertEquals(expect, actual)
		}
	}

	@Test
	fun testShortConversion() {
		repeat (ITERATIONS) {
			val expect = Random.nextInt().toShort()
			val int = Integer.fromKotlin(expect)
			val actual = int.asShort
			assertEquals(expect, actual)
		}
	}

	@Test
	fun testUShortConversion() {
		repeat (ITERATIONS) {
			val expect = Random.nextInt().toUShort()
			val int = Integer.fromKotlin(expect)
			val actual = int.asUShort
			assertEquals(expect, actual)
		}
	}

	@Test
	fun testIntConversion() {
		repeat (ITERATIONS) {
			val expect = Random.nextInt()
			val int = Integer.fromKotlin(expect)
			val actual = int.asInt
			assertEquals(expect, actual)
		}
	}

	@Test
	fun testUIntConversion() {
		repeat (ITERATIONS) {
			val expect = Random.nextUInt()
			val int = Integer.fromKotlin(expect)
			val actual = int.asUInt
			assertEquals(expect, actual)
		}
	}

	@Test
	fun testLongConversion() {
		repeat (ITERATIONS) {
			val expect = Random.nextLong()
			val int = Integer.fromKotlin(expect)
			val actual = int.asLong
			assertEquals(expect, actual)
		}
	}

	@Test
	fun testULongConversion() {
		repeat (ITERATIONS) {
			val expect = Random.nextULong()
			val int = Integer.fromKotlin(expect)
			val actual = int.asULong
			assertEquals(expect, actual)
		}
	}



	@Test
	fun testAddition1() {
		repeat (ITERATIONS) {
			val op1 = Random.nextUInt().toULong()
			val op2 = Random.nextUInt().toULong()
			val expect = op1 + op2

			val op12 = Integer.fromKotlin(op1)
			val op22 = Integer.fromKotlin(op2)
			val actual2 = op12 + op22
			val actual = actual2.asULong

			if (expect != actual) {
				val bin1 = op1.toString(2)
				val bin2 = op2.toString(2)
				val bin3 = expect.toString(2)
				val bin4 = actual.toString(2)
				val size = max(bin1.length, bin2.length)

				println("  " + " ".repeat(size - bin1.length) + bin1)
				println("+ " + " ".repeat(size - bin2.length) + bin2)
				println("-".repeat(size + 2))
				println(" ".repeat(size + 2 - bin3.length) + bin3 + " [EXPECTED]")
				println(" ".repeat(size + 2 - bin4.length) + bin4 + " [ACTUAL]")

			}

			assertEquals(expect, actual)
		}
	}

	@Test
	fun testSubtraction1() {
		repeat (ITERATIONS) {
			val op1 = Random.nextUInt().toULong()
			val op2 = Random.nextUInt().toULong()
			val expect = op1 + op2

			val op12 = Integer.fromKotlin(op1)
			val op22 = -Integer.fromKotlin(op2)
			val actual2 = op12 - op22
			val actual = actual2.asULong

			if (expect != actual) {
				val bin1 = op1.toString(2)
				val bin2 = op2.toString(2)
				val bin3 = expect.toString(2)
				val bin4 = actual.toString(2)
				val size = max(bin1.length, bin2.length)

				println("  " + " ".repeat(size - bin1.length) + bin1)
				println("+ " + " ".repeat(size - bin2.length) + bin2)
				println("-".repeat(size + 2))
				println(" ".repeat(size + 2 - bin3.length) + bin3 + " [EXPECTED]")
				println(" ".repeat(size + 2 - bin4.length) + bin4 + " [ACTUAL]")

			}

			assertEquals(expect, actual)
		}
	}

	@Test
	fun testSubtraction2() {
		repeat (ITERATIONS) {
			val op1 = Random.nextUInt().toULong()
			val op2 = Random.nextUInt().toULong()
			val expect = op1 - op2

			val op12 = Integer.fromKotlin(op1)
			val op22 = Integer.fromKotlin(op2)
			val actual2 = op12 - op22
			val actual = actual2.asULong

			if (expect != actual) {
				val bin1 = op1.toString(2)
				val bin2 = op2.toString(2)
				val bin3 = expect.toString(2)
				val bin4 = actual.toString(2)
				val size = max(bin1.length, bin2.length)

				println("  " + " ".repeat(size - bin1.length) + bin1)
				println("+ " + " ".repeat(size - bin2.length) + bin2)
				println("-".repeat(size + 2))
				println(" ".repeat(size + 2 - bin3.length) + bin3 + " [EXPECTED]")
				println(" ".repeat(size + 2 - bin4.length) + bin4 + " [ACTUAL]")

			}

			assertEquals(expect, actual)
		}
	}



	@Test
	fun testCompare1() {
		repeat (ITERATIONS) {
			val a = Random.nextULong()
			val b = Random.nextULong()
			val a2 = Integer.fromKotlin(a)
			val b2 = Integer.fromKotlin(b)

			val compare1 = a.compareTo(b)
			val compare2 = a2.compareTo(b2)

			if (compare1 != compare2) {
				println("Comparing $a with $b")
			}
			assertEquals(compare1, compare2)
		}
	}

	@Test
	fun testCompare2() {
		repeat (ITERATIONS) {
			val a = Random.nextUInt()
			val b = Random.nextUInt()
			val a2 = -Integer.fromKotlin(a)
			val b2 = -Integer.fromKotlin(b)
			val a3 = -a.toLong()
			val b3 = -b.toLong()

			val compare1 = a3.compareTo(b3)
			val compare2 = a2.compareTo(b2)

			if (compare1 != compare2) {
				println("Comparing $a3 with $b3")
			}
			assertEquals(compare1, compare2)
		}
	}

	@Test
	fun testCompare3() {
		repeat (ITERATIONS) {
			val a = Random.nextUInt()
			val b = Random.nextUInt()
			val a2 = if (Random.nextBoolean()) Integer.fromKotlin(a) else -Integer.fromKotlin(a)
			val b2 = if (Random.nextBoolean()) Integer.fromKotlin(b) else -Integer.fromKotlin(b)
			val a3 = if (a2.isNegative) -a.toLong() else a.toLong()
			val b3 = if (b2.isNegative) -b.toLong() else b.toLong()

			val compare1 = a3.compareTo(b3)
			val compare2 = a2.compareTo(b2)

			if (compare1 != compare2) {
				println("Comparing $a3 with $b3")
			}
			assertEquals(compare1, compare2)
		}
	}

}
