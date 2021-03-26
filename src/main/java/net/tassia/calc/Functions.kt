package net.tassia.calc

import net.tassia.calc.element.Decimal
import net.tassia.calc.element.Integer



/**
 * Converts this [Byte] to an [Integer].
 *
 * @return the integer
 */
fun Byte.calc(): Integer = Integer(this.toLong())

/**
 * Converts this [Short] to an [Integer].
 *
 * @return the integer
 */
fun Short.calc(): Integer = Integer(this.toLong())

/**
 * Converts this [Int] to an [Integer].
 *
 * @return the integer
 */
fun Int.calc(): Integer = Integer(this.toLong())

/**
 * Converts this [Long] to an [Integer].
 *
 * @return the integer
 */
fun Long.calc(): Integer = Integer(this)



/**
 * Converts this [Float] to a [Decimal].
 *
 * @return the decimal
 */
fun Float.calc(): Decimal = Decimal(this.toDouble())

/**
 * Converts this [Double] to a [Decimal].
 *
 * @return the decimal
 */
fun Double.calc(): Decimal = Decimal(this)



/**
 * Creates a new collection, containing the elements of this collection and `e`.
 *
 * @param e the element to add
 * @return the new collection
 */
fun <T> Collection<T>.merge(e: T): Collection<T> {
	val temp = this.toMutableList()
	temp.add(e)
	return temp
}
