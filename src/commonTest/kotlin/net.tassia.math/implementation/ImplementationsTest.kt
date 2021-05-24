package net.tassia.math.implementation

import net.tassia.math.ITERATIONS
import kotlin.random.Random
import kotlin.test.*

class ImplementationsTest {

	@Test
	fun testAdd1() {
		val b1 = 0x04.toUByte()
		val b2 = 0x05.toUByte()
		val expected = 0x09.toUByte()
		val actual = Implementations.add(b1, b2, false)
		assertEquals(expected, actual.first)
		assertFalse(actual.second)
	}

	@Test
	fun testAdd2() {
		val b1 = 0x04.toUByte()
		val b2 = 0x05.toUByte()
		val expected = 0x0A.toUByte()
		val actual = Implementations.add(b1, b2, true)
		assertEquals(expected, actual.first)
		assertFalse(actual.second)
	}

	@Test
	fun testAdd3() {
		val b1 = 0xF4.toUByte()
		val b2 = 0xF5.toUByte()
		val expected = (b1 + b2).toUByte()
		val actual = Implementations.add(b1, b2, false)
		assertEquals(expected, actual.first)
		assertTrue(actual.second)
	}

	@Test
	fun testAdd4() {
		val b1 = 0xF4.toUByte()
		val b2 = 0xF5.toUByte()
		val expected = (b1 + b2 + 1U).toUByte()
		val actual = Implementations.add(b1, b2, true)
		assertEquals(expected, actual.first)
		assertTrue(actual.second)
	}

	@Test
	fun testAdd5() {
		repeat (ITERATIONS) {
			val b1 = Random.nextBytes(1).first().toUByte()
			val b2 = Random.nextBytes(1).first().toUByte()
			val expected = (b1 + b2).toUByte()
			val actual = Implementations.add(b1, b2, false)
			assertEquals(expected, actual.first)
		}
	}

	@Test
	fun testAdd6() {
		repeat (ITERATIONS) {
			val b1 = Random.nextBytes(1).first().toUByte()
			val b2 = Random.nextBytes(1).first().toUByte()
			val expected = (b1 + b2 + 1U).toUByte()
			val actual = Implementations.add(b1, b2, true)
			assertEquals(expected, actual.first)
		}
	}



	@Test
	fun testReduceIntegerData1() {
		val source = byteArrayOf(0x00, 0x00, 0x00, 0x01)
		val expected = byteArrayOf(0x01)
		val actual = Implementations.reduceIntegerData(source)
		assertContentEquals(expected, actual)
	}

	@Test
	fun testReduceIntegerData2() {
		val source = byteArrayOf(0x01)
		val expected = byteArrayOf(0x01)
		val actual = Implementations.reduceIntegerData(source)
		assertContentEquals(expected, actual)
	}

	@Test
	fun testReduceIntegerData3() {
		val source = byteArrayOf(0x00)
		val expected = byteArrayOf()
		val actual = Implementations.reduceIntegerData(source)
		assertContentEquals(expected, actual)
	}

	@Test
	fun testReduceIntegerData4() {
		val source = byteArrayOf(0x01, 0x00, 0x00, 0x00, 0x01)
		val expected = byteArrayOf(0x01, 0x00, 0x00, 0x00, 0x01)
		val actual = Implementations.reduceIntegerData(source)
		assertContentEquals(expected, actual)
	}

}
