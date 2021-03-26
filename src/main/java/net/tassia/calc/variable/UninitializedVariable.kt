package net.tassia.calc.variable

import net.tassia.calc.ICalculatable
import net.tassia.calc.MathException

/**
 * A [Variable] that is not initialized with a default value.
 *
 * **Note:** Due to the variable not being initialized, accessing it before assigning it
 * can cause [MathException]s to be thrown.
 *
 * @param name the name of the variable
 * @param value the value of the variable
 *
 * @since Calc 1.0
 * @author Tassilo
 */
class UninitializedVariable(name: String, private var value: ICalculatable? = null) : Variable(name) {

	override fun get(): ICalculatable = value ?: throw MathException("Variable $name cannot be accessed before it is initialized.")

	override fun set(value: ICalculatable) {
		this.value = value
	}

}
