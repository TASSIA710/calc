package net.tassia.calc

import kotlin.math.floor

/**
 * Collection of useful math functions.
 *
 * @since Calc 1.0
 * @author Tassilo
 */
object Math {

	/**
	 * Calculates the square root for the given value.
	 *
	 * @param value the value
	 * @return the square root
	 */
	fun sqrt(value: ICalculatable): ICalculatable {
		TODO()
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
