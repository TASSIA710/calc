package net.tassia.math.function

open class FunctionMeta (

	val name: String,
	val symbol: String,
	val type: FunctionType,

) {

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (other == null || other !is FunctionMeta) return false

		if (name != other.name) return false
		if (symbol != other.symbol) return false
		if (type != other.type) return false

		return true
	}

	override fun hashCode(): Int {
		var result = name.hashCode()
		result = 31 * result + symbol.hashCode()
		result = 31 * result + type.hashCode()
		return result
	}

}
