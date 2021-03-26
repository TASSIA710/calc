package net.tassia.calc.variable

import net.tassia.calc.ICalculatable

/**
 * A variable holds a specific value in an environment.
 *
 * @param name the name of the variable
 *
 * @since Calc 1.0
 * @author Tassilo
 */
abstract class Variable(val name: String) {

	/**
	 * Returns the current value of this variable.
	 *
	 * @return the value
	 */
	abstract fun get(): ICalculatable

	/**
	 * Updates the value of this variable.
	 *
	 * @param value the new value for this variable
	 */
	abstract fun set(value: ICalculatable)



	companion object {

		/**
		 * A set containing default variables for new environments.
		 */
		val DefaultVariables: Set<Variable> = setOf(
			Constants.E, Constants.PI
		)

	}

}
