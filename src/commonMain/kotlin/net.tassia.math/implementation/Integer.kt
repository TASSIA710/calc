package net.tassia.math.implementation

class Integer(private val sign: Boolean, private val data: ByteArray) {

	operator fun plus(other: Integer): Integer {
		if (sign == other.sign) {
			// Both operands are positive or negative, nice.
			return Integer(sign, Implementations.reduceIntegerData(Implementations.add(data, other.data)))
		}

		// Signs differ, this makes the addition a bit more complex, as it is essentially a subtraction.
		// => a + -b => a - b
		return this - (-other)
	}

	operator fun minus(other: Integer): Integer {
		if (sign == other.sign) {
			// Both operands are positive or negative, nice.
			if (this == other) return ZERO
			if (this > other) {
				// "this" is bigger than "other", we can safely subtract
				return safeSubtract(other)
			}

			// "this" is smaller than "other", so we can flip the operands if we flip the sign
			// => a - b => 0 - (b - a)
			// => 2 - 5 (= -3) => 0 - (5 - 2) => 0 - 3 (= -3)
			return -other.safeSubtract(this)
		}

		// Signs differ, this makes subtraction effectively work as an addition.
		// => a - -b => a + b
		return this + (-other)
	}

	/**
	 * A safe subtraction ensures both operands are of equal sign and that `this` is greater than `other`.
	 *
	 * @param other the value to subtract
	 * @return the subtraction result
	 */
	private fun safeSubtract(other: Integer): Integer {
		TODO()
	}

	operator fun times(other: Integer): Integer {
		TODO()
	}

	operator fun div(other: Integer): Integer {
		TODO()
	}

	operator fun rem(other: Integer): Integer {
		TODO()
	}

	infix fun pow(other: Integer): Integer {
		TODO()
	}



	operator fun unaryPlus(): Integer {
		return this
	}

	operator fun unaryMinus(): Integer {
		return Integer(!sign, data)
	}



	operator fun inc(): Integer {
		return this + ONE
	}

	operator fun dec(): Integer {
		return this - ONE
	}



	override operator fun equals(other: Any?): Boolean {
		if (other == null || other !is Integer) return false
		return this.compareTo(other) == 0
	}

	override fun hashCode(): Int {
		var hash = sign.hashCode()
		for (byte in data) {
			hash = 31 * hash + byte.hashCode()
		}
		return hash
	}

	operator fun compareTo(other: Integer): Int {
		if (this.isZero && other.isZero) return 0
		if (this.sign != other.sign) {
			return if (sign) -1 else 1
		}
		val (a, b) = Implementations.generateEqualSizes(this.data, other.data)
		for (index in a.indices) {
			val byteA = a[index].toUByte()
			val byteB = b[index].toUByte()
			if (byteA != byteB) {
				return if (sign) {
					-byteA.compareTo(byteB)
				} else {
					byteA.compareTo(byteB)
				}
			}
		}
		return 0
	}

	override fun toString(): String {
		TODO()
	}

	fun toBinaryString(padding: Int = 8): String {
		val builder = StringBuilder()
		if (sign) builder.append(SIGN_CHARACTER)
		builder.append(BINARY_PREFIX)
		if (padding > data.size * 8) {
			for (i in 0 until (padding - data.size * 8)) {
				builder.append('0')
			}
		}
		for (byte in data) {
			Implementations.binaryByte(byte, builder)
		}
		return builder.toString()
	}

	fun toHexString(padding: Int = 2): String {
		val builder = StringBuilder()
		if (sign) builder.append(SIGN_CHARACTER)
		builder.append(HEX_PREFIX)
		if (padding > data.size * 2) {
			for (i in 0 until (padding - data.size * 2)) {
				builder.append('0')
			}
		}
		for (byte in data) {
			Implementations.hexByte(byte, builder)
		}
		return builder.toString()
	}



	val isZero: Boolean by lazy {
		for (byte in data) {
			if (byte != BYTE_ZERO) {
				return@lazy false
			}
		}
		return@lazy true
	}

	val isPositive: Boolean by lazy { !isZero && !sign }
	val isNegative: Boolean by lazy { !isZero && sign }



	@Suppress("NOTHING_TO_INLINE")
	private inline fun byteAt(index: Int): Int {
		return (data.getOrNull(index) ?: 0x00).toInt()
	}



	val asByte: Byte
		get() = data.lastOrNull() ?: 0x00

	val asUByte: UByte
		get() = data.lastOrNull()?.toUByte() ?: 0x00u

	val asShort: Short
		get() {
			var buffer = 0

			buffer = buffer or (byteAt(data.size - 2) and 0xFF)
			buffer = buffer shl 8

			buffer = buffer or (byteAt(data.size - 1) and 0xFF)
			return buffer.toShort()
		}

	val asUShort: UShort
		get() {
			var buffer = 0

			buffer = buffer or (byteAt(data.size - 2) and 0xFF)
			buffer = buffer shl 8

			buffer = buffer or (byteAt(data.size - 1) and 0xFF)
			return buffer.toUShort()
		}

	val asInt: Int
		get() {
			var buffer = 0

			buffer = buffer or (byteAt(data.size - 4) and 0xFF)
			buffer = buffer shl 8

			buffer = buffer or (byteAt(data.size - 3) and 0xFF)
			buffer = buffer shl 8

			buffer = buffer or (byteAt(data.size - 2) and 0xFF)
			buffer = buffer shl 8

			buffer = buffer or (byteAt(data.size - 1) and 0xFF)
			return buffer
		}

	val asUInt: UInt
		get() {
			var buffer = 0

			buffer = buffer or (byteAt(data.size - 4) and 0xFF)
			buffer = buffer shl 8

			buffer = buffer or (byteAt(data.size - 3) and 0xFF)
			buffer = buffer shl 8

			buffer = buffer or (byteAt(data.size - 2) and 0xFF)
			buffer = buffer shl 8

			buffer = buffer or (byteAt(data.size - 1) and 0xFF)
			return buffer.toUInt()
		}

	val asLong: Long
		get() {
			var buffer = 0L

			buffer = buffer or (byteAt(data.size - 8).toLong() and 0xFF)
			buffer = buffer shl 8

			buffer = buffer or (byteAt(data.size - 7).toLong() and 0xFF)
			buffer = buffer shl 8

			buffer = buffer or (byteAt(data.size - 6).toLong() and 0xFF)
			buffer = buffer shl 8

			buffer = buffer or (byteAt(data.size - 5).toLong() and 0xFF)
			buffer = buffer shl 8

			buffer = buffer or (byteAt(data.size - 4).toLong() and 0xFF)
			buffer = buffer shl 8

			buffer = buffer or (byteAt(data.size - 3).toLong() and 0xFF)
			buffer = buffer shl 8

			buffer = buffer or (byteAt(data.size - 2).toLong() and 0xFF)
			buffer = buffer shl 8

			buffer = buffer or (byteAt(data.size - 1).toLong() and 0xFF)
			return buffer
		}

	val asULong: ULong
		get() {
			var buffer = 0UL

			buffer = buffer or (byteAt(data.size - 8).toULong() and 255UL)
			buffer = buffer shl 8

			buffer = buffer or (byteAt(data.size - 7).toULong() and 255UL)
			buffer = buffer shl 8

			buffer = buffer or (byteAt(data.size - 6).toULong() and 255UL)
			buffer = buffer shl 8

			buffer = buffer or (byteAt(data.size - 5).toULong() and 255UL)
			buffer = buffer shl 8

			buffer = buffer or (byteAt(data.size - 4).toULong() and 255UL)
			buffer = buffer shl 8

			buffer = buffer or (byteAt(data.size - 3).toULong() and 255UL)
			buffer = buffer shl 8

			buffer = buffer or (byteAt(data.size - 2).toULong() and 255UL)
			buffer = buffer shl 8

			buffer = buffer or (byteAt(data.size - 1).toULong() and 255UL)
			return buffer
		}



	companion object {

		val ZERO = Integer(false, ByteArray(0))
		val ONE = Integer(false, ByteArray(1) { 0x01 })
		val TWO = Integer(false, ByteArray(1) { 0x02 })

		fun fromKotlin(kotlin: Byte): Integer {
			return Integer(false, byteArrayOf(kotlin))
		}

		fun fromKotlin(kotlin: UByte): Integer {
			return Integer(false, byteArrayOf(kotlin.toByte()))
		}

		fun fromKotlin(kotlin: Short): Integer {
			return Integer(false, byteArrayOf(
				(kotlin.toUInt() shr 8).toByte(),
				kotlin.toByte()
			))
		}

		fun fromKotlin(kotlin: UShort): Integer {
			return Integer(false, byteArrayOf(
				(kotlin.toUInt() shr 8).toByte(),
				kotlin.toByte()
			))
		}

		fun fromKotlin(kotlin: Int): Integer {
			return Integer(false, byteArrayOf(
				(kotlin shr 24).toByte(),
				(kotlin shr 16).toByte(),
				(kotlin shr 8).toByte(),
				kotlin.toByte()
			))
		}

		fun fromKotlin(kotlin: UInt): Integer {
			return Integer(false, byteArrayOf(
				(kotlin shr 24).toByte(),
				(kotlin shr 16).toByte(),
				(kotlin shr 8).toByte(),
				kotlin.toByte()
			))
		}

		fun fromKotlin(kotlin: Long): Integer {
			return Integer(false, byteArrayOf(
				(kotlin shr 56).toByte(),
				(kotlin shr 48).toByte(),
				(kotlin shr 40).toByte(),
				(kotlin shr 32).toByte(),
				(kotlin shr 24).toByte(),
				(kotlin shr 16).toByte(),
				(kotlin shr 8).toByte(),
				kotlin.toByte()
			))
		}

		fun fromKotlin(kotlin: ULong): Integer {
			return Integer(false, byteArrayOf(
				(kotlin shr 56).toByte(),
				(kotlin shr 48).toByte(),
				(kotlin shr 40).toByte(),
				(kotlin shr 32).toByte(),
				(kotlin shr 24).toByte(),
				(kotlin shr 16).toByte(),
				(kotlin shr 8).toByte(),
				kotlin.toByte()
			))
		}

	}

}
