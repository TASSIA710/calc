package net.tassia.calc

import net.tassia.calc.function.Function
import net.tassia.calc.parser.StandardMathParser
import net.tassia.calc.variable.Variable

/**
 * Represents a mathematical environment. An environment is defined by it's functions and variables.
 *
 * @since Calc 1.0
 * @author Tassilo
 */
class Environment {

	/**
	 * The functions of this environment.
	 */
	val functions: MutableSet<Function> = Function.DefaultFunctions.toMutableSet()

	/**
	 * The variables of this environment.
	 */
	val variables: MutableSet<Variable> = Variable.DefaultVariables.toMutableSet()



	/**
	 * Finds a function by it's [Function.name].
	 *
	 * @param name the name to search for
	 * @return the function, or `null`
	 */
	fun findFunction(name: String): Function? = functions.find { it.name.equals(name, true) }

	/**
	 * Finds a variable by it's [Variable.name].
	 *
	 * @param name the name to search for
	 * @return the variable, or `null`
	 */
	fun findVariable(name: String): Variable? = variables.find { it.name.equals(name, true) }



	fun parse(input: String): ICalculatable = StandardMathParser.parseFunctionString(input, this)
	fun run(input: String): Double = parse(input).evaluateDouble()

}
