package net.tassia.calc.variable

import net.tassia.calc.ICalculatable

/**
 * Variables are a fundamental part of mathematics.
 *
 * @param name the name of the variable
 *
 * @since Calc 1.0
 * @author Tassilo
 *
 * @see Constant
 */
abstract class Variable (

	/**
	 * The name of this variable.
	 */
	open val name: String,

) {

	/**
	 * Fetches the value of this variable.
	 *
	 * @return the value
	 */
	abstract fun evaluate(): ICalculatable

}
