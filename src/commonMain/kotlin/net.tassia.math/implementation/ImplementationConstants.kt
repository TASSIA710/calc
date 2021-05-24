package net.tassia.math.implementation

internal const val SIGN_CHARACTER = '-'
internal const val HEX_PREFIX = "0x"
internal const val BINARY_PREFIX = "0b"

internal const val BYTE_MASK_MOST_SIG_4 = 0b11110000.toByte()
internal const val BYTE_MASK_LEAST_SIG_4 = 0b00001111.toByte()

internal const val BYTE_ZERO = 0x00.toByte()

internal const val BYTE_SIGN_MASK = 128.toByte()
internal const val BYTE_SIGN_MASK_INV = 127.toByte()

internal const val SHORT_SIGN_MASK = (Short.MAX_VALUE + 1).toShort()
internal const val SHORT_SIGN_MASK_INV = Short.MAX_VALUE

@Suppress("INTEGER_OVERFLOW")
internal const val INT_SIGN_MASK = Int.MAX_VALUE + 1
internal const val INT_SIGN_MASK_INV = Int.MAX_VALUE

@Suppress("INTEGER_OVERFLOW")
internal const val LONG_SIGN_MASK = Long.MAX_VALUE + 1
internal const val LONG_SIGN_MASK_INV = Long.MAX_VALUE
