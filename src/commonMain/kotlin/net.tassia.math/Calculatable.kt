package net.tassia.math

import net.tassia.math.constant.Constants
import net.tassia.math.set.Range

abstract class Calculatable {

	open operator fun plus(other: Calculatable): Calculatable {
		return Sum(listOf(this, other))
	}

	open operator fun minus(other: Calculatable): Calculatable {
		return Sum(listOf(this, -other))
	}

	open operator fun times(other: Calculatable): Calculatable {
		return Product(listOf(this, other))
	}

	open operator fun div(other: Calculatable): Calculatable {
		return Fraction(this, other)
	}

	open infix fun pow(other: Calculatable): Calculatable {
		return Exponentiation(this, other)
	}

	// TODO: Remainder



	open operator fun unaryPlus(): Calculatable {
		return this * Constants.ONE
	}

	open operator fun unaryMinus(): Calculatable {
		return this * Constants.NEGATIVE_ONE
	}



	open operator fun inc(): Calculatable {
		return this + Constants.ONE
	}

	open operator fun dec(): Calculatable {
		return this - Constants.ONE
	}



	override operator fun equals(other: Any?): Boolean {
		if (other == null || other !is Calculatable) return false
		return this.compareTo(other) == 0
	}

	abstract override fun hashCode(): Int

	abstract operator fun compareTo(other: Calculatable): Int

	abstract override fun toString(): String

	operator fun rangeTo(to: Calculatable): Range {
		return Range.II(this, to)
	}



	abstract val isPositive: Boolean
	abstract val isZero: Boolean
	abstract val isNegative: Boolean



	open fun exp(): Calculatable {
		return Constants.E pow this
	}

}
