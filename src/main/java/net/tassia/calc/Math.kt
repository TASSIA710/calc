package net.tassia.calc

/**
 * Collection of useful math functions.
 *
 * @since Calc 1.0
 * @author Tassilo
 */
object Math {

	/**
	 * Calculates the square root for the given float value.
	 *
	 * @param value the value
	 * @return the square root
	 */
	fun sqrt(value: Float): Float {
		return kotlin.math.sqrt(value)
	}

	/**
	 * Calculates the square root for the given double value.
	 *
	 * @param value the value
	 * @return the square root
	 */
	fun sqrt(value: Double): Double {
		return kotlin.math.sqrt(value)
	}

}
