package net.tassia.math.implementation

import net.tassia.math.either
import kotlin.experimental.and
import kotlin.math.max

object Implementations {

	@Deprecated("Switch to unsigned bytes", ReplaceWith("add(UByte, UByte, Boolean): Pair<UByte, Boolean>"))
	fun add(a: Byte, b: Byte, overflow: Boolean): Pair<Byte, Boolean> {
		val result = a.toInt() + b.toInt() + either(overflow, 1, 0)
		return (result and 0xFF).toByte() to (result shr 8 != 0)
	}

	fun add(a: ByteArray, b: ByteArray): ByteArray {
		val equalSized = generateEqualSizes(a, b)
		return addEqualSized(equalSized.first, equalSized.second)
	}

	private fun addEqualSized(a: ByteArray, b: ByteArray): ByteArray {
		val data = ByteArray(a.size)
		var overflow = false
		for (index in data.indices.reversed()) {
			val result = add(a[index].toUByte(), b[index].toUByte(), overflow)
			data[index] = result.first.toByte()
			overflow = result.second
		}
		return data
	}

	fun add(a: UByte, b: UByte, overflow: Boolean): Pair<UByte, Boolean> {
		val result = a.toInt() + b.toInt() + either(overflow, 1, 0)
		return (result and 0xFF).toUByte() to (result shr 8 != 0)
	}



	fun reduceIntegerData(data: ByteArray): ByteArray {
		var stripCount = 0
		for (byte in data) {
			if (byte == BYTE_ZERO) stripCount++ else break
		}
		return ByteArray(data.size - stripCount) {
			data[it + stripCount]
		}
	}



	fun generateEqualSizes(a: ByteArray, b: ByteArray): Pair<ByteArray, ByteArray> {
		val size = max(a.size, b.size) + 1
		return ByteArray(size) {
			val index = it - size + a.size
			return@ByteArray if (index >= 0) a[index] else BYTE_ZERO
		} to ByteArray(size) {
			val index = it - size + b.size
			return@ByteArray if (index >= 0) b[index] else BYTE_ZERO
		}
	}



	fun binaryByte(byte: Byte, builder: StringBuilder) {
		TODO()
	}

	fun hexByte(byte: Byte, builder: StringBuilder) {
		val a = (byte and BYTE_MASK_MOST_SIG_4).toInt() shr 4
		val b = (byte and BYTE_MASK_LEAST_SIG_4).toInt()
		builder.append(hexTable[a]).append(hexTable[b])
	}

	private val hexTable = charArrayOf(
		'0', '1', '2', '3', '4', '5', '6', '7',
		'8', '9', 'a', 'b', 'c', 'd', 'e', 'f',
	)

}
