package net.tassia.calc.parser

import net.tassia.calc.Environment
import net.tassia.calc.ICalculatable

/**
 * Used to parse [String]s to [ICalculatable]s.
 *
 * @since Calc 1.0
 * @author Tassilo
 */
interface IMathParser {

	/**
	 * Parses a function string.
	 *
	 * @param input the string to parse
	 * @param env the environment to use
	 * @return the parsed [ICalculatable]
	 *
	 * @see [ICalculatable.toFunctionString]
	 */
	fun parseFunctionString(input: String, env: Environment): ICalculatable

}
