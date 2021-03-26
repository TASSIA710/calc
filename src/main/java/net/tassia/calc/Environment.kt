package net.tassia.calc

import net.tassia.calc.function.Function
import net.tassia.calc.variable.Variable

/**
 * Represents a mathematical environment. An environment is defined
 * by specific set of functions (e.g. SQRT) and variables (e.g. PI).
 *
 * @since Calc 1.0
 * @author Tassilo
 */
class Environment {

	/**
	 * A set of functions included within this environment.
	 */
	val functions: MutableSet<Function> = mutableSetOf()

	/**
	 * A set of variables included within this environment.
	 */
	val variables: MutableSet<Variable> = mutableSetOf()



	/**
	 * Finds a function by it's name and argument count.
	 *
	 * @param name the name
	 * @param args the argument count
	 * @return the function, or `null`
	 */
	fun findFunction(name: String, args: Int): Function? {
		return functions.find { it.name.equals(name, true) && it.argCount.contains(args) }
	}

	/**
	 * Finds a variable by it's name.
	 *
	 * @param name the name
	 * @return the variable, or `null`
	 */
	fun findVariable(name: String): Variable? {
		return variables.find { it.name.equals(name, true) }
	}

}
