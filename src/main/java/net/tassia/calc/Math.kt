package net.tassia.calc

import kotlin.math.floor
import kotlin.math.pow

/**
 * Collection of useful math functions.
 *
 * @since Calc 1.0
 * @author Tassilo
 */
object Math {

	fun pow(value: Double, exponent: Double): Double {
		return value.pow(exponent)
	}

	fun pow(value: Long, exponent: Long): Long {
		return value.toDouble().pow(exponent.toDouble()).toLong()
	}



	/**
	 * Calculates the square root for the given [Double] value.
	 *
	 * @param value the value
	 * @return the square root
	 */
	fun sqrt(value: Double): Double {
		return kotlin.math.sqrt(value)
	}



	/**
	 * Tests if the given double is an integer.
	 *
	 * @param test the double to test
	 * @return is integer
	 */
	fun isInteger(test: Double): Boolean {
		return floor(test) == test
	}

}
