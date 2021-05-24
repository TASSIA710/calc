package net.tassia.math.constant

abstract class IrrationalConstant(private val name: String) : Constant() {

	override fun hashCode(): Int {
		return "IRRATIONAL-CONSTANT: $name".hashCode()
	}

	override fun equals(other: Any?): Boolean {
		// Irrational constants should be singletons
		return this === other
	}

	override fun toString(): String {
		return name
	}

}
