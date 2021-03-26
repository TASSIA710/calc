package net.tassia.calc.parser

import net.tassia.calc.Environment
import net.tassia.calc.ICalculatable
import net.tassia.calc.calc
import net.tassia.calc.element.FunctionCall
import net.tassia.calc.element.Integer
import net.tassia.calc.element.VariableCall

class InstantiatedFunctionStringParser(private val source: String, private val env: Environment) {

	fun parse(): ICalculatable = readElement()



	private fun readElement(): ICalculatable {
		skipWhitespace()
		if (peek().isLetter()) {
			// Read function or variable call
			val name = nextWhile { it.isLetter() || it.isDigit() || it == '_' }
			skipWhitespace()
			if (peek() == '(') {
				// Read function call
				next(); skipWhitespace()

				// Read arguments
				val args: MutableList<ICalculatable> = mutableListOf()
				while (true) {
					args.add(readElement())
					skipWhitespace()
					if (isNext(',')) {
						skipWhitespace()
					} else if (isNext(')')) {
						break
					} else {
						throw IllegalArgumentException("Unknown character: ${peek()}")
					}
				}
				val function = env.findFunction(name) ?: throw IllegalArgumentException("Unknown function: $name")
				return FunctionCall(function, args)

			} else {
				// Read variable call
				val variable = env.findVariable(name) ?: throw IllegalArgumentException("Unknown variable: $name")
				return VariableCall(variable)

			}

		} else if (peek().isDigit()) {
			// Read number
			val int = readInteger()
			skipWhitespace()
			if (isPeek('.')) {
				// TODO: Fix this very, very hacky workaround
				val decimalPart = readInteger()
				return "$int.$decimalPart".toDouble().calc()
			}
			return int

		} else {
			throw IllegalArgumentException("Unknown character: ${peek()}")
		}
	}

	private fun readInteger(): Integer {
		return (if (isNext("0b") || isNext("0B")) {
			// Read binary
			nextWhile { it == '0' || it == '1' }.toLong(2)

		} else if (isNext("0o") || isNext("0O")) {
			// Read octal
			nextWhile { it in '0'..'7' }.toLong(8)

		} else if (isNext("0x") || isNext("0X")) {
			// Read hexadecimal
			nextWhile { it in '0'..'9' || it in 'a'..'f' || it in 'A'..'F' }.toLong(16)

		} else {
			// Read decimal
			nextWhile { it in '0'..'9' }.toLong(10)

		}).calc()
	}



	private var index: Int = 0

	private fun peek(): Char = source[index]
	private fun peek(len: Int): String = source.substring(index, index + len)
	private fun next(): Char = source[index].also { index++ }
	private fun next(len: Int): String = peek(len).also { index += len }

	private fun isPeek(test: Char): Boolean = peek() == test
	private fun isPeek(test: String): Boolean = peek(test.length) == test

	private fun isNext(test: Char) = isPeek(test).also { if (it) next() }
	private fun isNext(test: String) = isPeek(test).also { if (it) next(test.length) }

	private fun nextWhile(predicate: (Char) -> Boolean): String {
		val builder = StringBuilder()
		while (predicate(peek())) builder.append(next())
		return builder.toString()
	}

	private fun skipWhitespace() = nextWhile(Character::isWhitespace)

}
