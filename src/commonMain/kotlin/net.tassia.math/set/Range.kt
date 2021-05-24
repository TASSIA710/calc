package net.tassia.math.set

import net.tassia.math.Calculatable

sealed class Range(val from: Calculatable, val to: Calculatable) {

	abstract operator fun contains(element: Calculatable): Boolean

	abstract override fun toString(): String





	class EE(from: Calculatable, to: Calculatable) : Range(from, to) {

		override fun contains(element: Calculatable): Boolean {
			return element > from && element < to
		}

		override fun toString(): String {
			return "]$from;$to["
		}

	}

	class EI(from: Calculatable, to: Calculatable) : Range(from, to) {

		override fun contains(element: Calculatable): Boolean {
			return element > from && element <= to
		}

		override fun toString(): String {
			return "]$from;$to]"
		}

	}

	class IE(from: Calculatable, to: Calculatable) : Range(from, to) {

		override fun contains(element: Calculatable): Boolean {
			return element >= from && element < to
		}

		override fun toString(): String {
			return "[$from;$to["
		}

	}

	class II(from: Calculatable, to: Calculatable) : Range(from, to) {

		override fun contains(element: Calculatable): Boolean {
			return element >= from && element <= to
		}

		override fun toString(): String {
			return "[$from;$to]"
		}

	}

}
