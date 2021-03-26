package net.tassia.calc

/**
 * Thrown if something goes mathematically wrong (e.g. calculating the sqrt of a negative number).
 *
 * @since Calc 1.0
 * @author Tassilo
 */
class MathException(

	/**
	 * The message attached to the error.
	 */
	override val message: String? = null,

	/**
	 * The cause attached to the error.
	 */
	override val cause: Throwable? = null,

) : Exception()
