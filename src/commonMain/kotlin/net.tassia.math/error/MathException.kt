package net.tassia.math.error

/**
 * The base exception for any mathematical error.
 *
 * @param message the error message, can be `null`
 * @param cause the cause of the error, can be `null`
 *
 * @author Tassilo
 */
open class MathException(message: String? = null, cause: Throwable? = null) : RuntimeException(message, cause)
