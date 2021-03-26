package net.tassia.calc.parser

import net.tassia.calc.Environment
import net.tassia.calc.ICalculatable

object StandardMathParser : IMathParser {

	override fun parseFunctionString(input: String, env: Environment): ICalculatable {
		return InstantiatedFunctionStringParser(input, env).parse()
	}

}
