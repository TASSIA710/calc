package net.tassia.calc.variable

import net.tassia.calc.ICalculatable

/**
 * A [Variable] that is initialized with a default value.
 *
 * @param name the name of the variable
 * @param value the value of the variable
 *
 * @since Calc 1.0
 * @author Tassilo
 */
class InitializedVariable(name: String, private var value: ICalculatable) : Variable(name) {

	override fun get(): ICalculatable = value

	override fun set(value: ICalculatable) {
		this.value = value
	}

}
