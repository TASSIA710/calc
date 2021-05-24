package net.tassia.math.vector

import net.tassia.math.Calculatable
import net.tassia.math.SquareRoot
import net.tassia.math.Sum
import net.tassia.math.constant.Constants
import net.tassia.math.error.IncompatibleVectorsException
import net.tassia.math.error.VectorCrossProductException

class Vector(val parameters: List<Calculatable>) : Calculatable() {

	constructor(vararg parameters: Calculatable) : this(parameters.toList())



	val dimensions: Int = parameters.size
	val isNormalized: Boolean by lazy { length() == Constants.ONE }

	override val isZero: Boolean by lazy { length() == Constants.ZERO }
	override val isPositive: Boolean by lazy { length() > Constants.ZERO }
	override val isNegative: Boolean by lazy { length() < Constants.ZERO }

	fun length(): Calculatable {
		return SquareRoot(Sum(parameters.map { it pow Constants.TWO }))
	}

	fun normalize(): Calculatable {
		return this / length()
	}

	private fun requireEqualDimensions(other: Vector) {
		if (dimensions != other.dimensions) {
			throw IncompatibleVectorsException(this, other, "Cannot perform arithmetic operation on $this and $other, as dimensions differ.")
		}
	}



	fun dot(other: Calculatable): Calculatable {
		return if (other !is Vector) {
			Sum(parameters.map { it * other })
		} else {
			this o other
		}
	}

	fun dot(other: Vector): Calculatable {
		requireEqualDimensions(other)
		return Sum(parameters.mapIndexed { index, element -> element * other.parameters[index] })
	}

	@Suppress("NOTHING_TO_INLINE")
	inline infix fun o(other: Calculatable): Calculatable {
		return dot(other)
	}

	@Suppress("NOTHING_TO_INLINE")
	inline infix fun o(other: Vector): Calculatable {
		return dot(other)
	}



	fun cross(other: Calculatable): Vector {
		if (other is Vector) {
			return this x other
		} else {
			throw VectorCrossProductException("Cross product requires 2nd operand to be a vector.")
		}
	}

	fun cross(other: Vector): Vector {
		TODO()
	}

	@Suppress("NOTHING_TO_INLINE")
	inline infix fun x(other: Calculatable): Vector {
		return cross(other)
	}

	@Suppress("NOTHING_TO_INLINE")
	inline infix fun x(other: Vector): Vector {
		return cross(other)
	}



	override operator fun plus(other: Calculatable): Vector {
		return if (other is Vector) {
			this + other
		} else {
			Vector(parameters.map { it + other })
		}
	}

	operator fun plus(other: Vector): Vector {
		requireEqualDimensions(other)
		return Vector(parameters.mapIndexed { index, element -> element + other.parameters[index] })
	}

	override operator fun minus(other: Calculatable): Vector {
		return if (other is Vector) {
			this - other
		} else {
			Vector(parameters.map { it - other })
		}
	}

	operator fun minus(other: Vector): Vector {
		requireEqualDimensions(other)
		return Vector(parameters.mapIndexed { index, element -> element - other.parameters[index] })
	}

	override operator fun times(other: Calculatable): Vector {
		return if (other is Vector) {
			this * other
		} else {
			Vector(parameters.map { it * other })
		}
	}

	operator fun times(other: Vector): Vector {
		requireEqualDimensions(other)
		return Vector(parameters.mapIndexed { index, element -> element * other.parameters[index] })
	}

	override operator fun div(other: Calculatable): Vector {
		return if (other is Vector) {
			this / other
		} else {
			Vector(parameters.map { it / other })
		}
	}

	operator fun div(other: Vector): Vector {
		requireEqualDimensions(other)
		return Vector(parameters.mapIndexed { index, element -> element / other.parameters[index] })
	}

	override infix fun pow(other: Calculatable): Vector {
		return if (other is Vector) {
			this pow other
		} else {
			Vector(parameters.map { it pow other })
		}
	}

	infix fun pow(other: Vector): Vector {
		requireEqualDimensions(other)
		return Vector(parameters.mapIndexed { index, element -> element pow other.parameters[index] })
	}



	override operator fun unaryPlus(): Vector {
		return this * Constants.ONE
	}

	override operator fun unaryMinus(): Vector {
		return this * Constants.NEGATIVE_ONE
	}

	// TODO: Bitwise Not



	override operator fun inc(): Vector {
		return this + this.normalize()
	}

	override operator fun dec(): Vector {
		return this - this.normalize()
	}



	override fun equals(other: Any?): Boolean {
		if (other == null || other !is Vector) return false
		if (dimensions != other.dimensions) return false
		for (index in parameters.indices) {
			if (parameters[index] != other.parameters[index]) return false
		}
		return true
	}

	override fun hashCode(): Int {
		var hash = "VECTOR".hashCode()
		hash = 31 * hash + dimensions.hashCode()
		for (parameter in parameters) {
			hash = 31 * hash + parameter.hashCode()
		}
		return hash
	}

	override operator fun compareTo(other: Calculatable): Int {
		return if (other is Vector) {
			length().compareTo(other.length())
		} else {
			length().compareTo(other)
		}
	}

	override fun toString(): String {
		return "{" + parameters.joinToString(", ") + "}"
	}

}
