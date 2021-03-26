package net.tassia.calc.element

import net.tassia.calc.ICalculatable
import net.tassia.calc.IFunctionString
import net.tassia.calc.calc
import net.tassia.calc.element.poly.Sum
import net.tassia.calc.element.unary.SquareRoot

class Vector(private val values: Array<ICalculatable>) : IFunctionString {

	operator fun plus(other: Vector): Vector {
		requireEqualDimensions(other)
		return Vector(Array(values.size) { values[it] + other.values[it] })
	}

	operator fun minus(other: Vector): Vector {
		requireEqualDimensions(other)
		return Vector(Array(values.size) { values[it] - other.values[it] })
	}

	operator fun times(other: ICalculatable): Vector = times(Vector(Array(values.size) { other }))

	operator fun times(other: Vector): Vector {
		requireEqualDimensions(other)
		return Vector(Array(values.size) { values[it] * other.values[it] })
	}

	operator fun div(other: ICalculatable): Vector = div(Vector(Array(values.size) { other }))

	operator fun div(other: Vector): Vector {
		requireEqualDimensions(other)
		return Vector(Array(values.size) { values[it] / other.values[it] })
	}

	operator fun rem(other: Vector): Vector {
		requireEqualDimensions(other)
		return Vector(Array(values.size) { values[it] % other.values[it] })
	}



	fun dot(other: Vector): ICalculatable {
		requireEqualDimensions(other)
		return Sum(List(values.size) { values[it] * other.values[it] })
	}

	fun length(): ICalculatable = SquareRoot(Sum(List(values.size) {
		return@List values[it] pow 2.calc()
	}))



	fun cross(other: Vector): Vector = TODO()



	fun normalize(): Vector = this / length()
	fun distance(other: Vector): ICalculatable = (other - this).length()

	infix fun x(other: Vector): Vector = cross(other)
	infix fun o(other: Vector): ICalculatable = dot(other)

	operator fun unaryPlus(): Vector = this
	operator fun unaryMinus(): Vector = times((-1).calc())



	override fun toFunctionString(): String {
		return "{" + values.joinToString(transform = ICalculatable::toFunctionString) + "}"
	}



	fun simplify(): Vector = Vector(Array(values.size) { values[it].simplify() })

	fun evaluateFloat(): Array<Float> = Array(values.size) { values[it].evaluateFloat() }

	fun evaluateDouble(): Array<Double> = Array(values.size) { values[it].evaluateDouble() }

	fun evaluateInt(): Array<Int> = Array(values.size) { values[it].evaluateInt() }

	fun evaluateLong(): Array<Long> = Array(values.size) { values[it].evaluateLong() }



	private fun requireEqualDimensions(other: Vector) {
		if (other.values.size != values.size) {
			throw IllegalArgumentException("Both vectors need to have the same dimensions for this operation to succeed.")
		}
	}

}
