package net.tassia.math

import net.tassia.math.function.binary.DivideFunction
import net.tassia.math.function.binary.PowerFunction
import net.tassia.math.function.poly.AddFunction
import net.tassia.math.function.poly.MultiplyFunction
import net.tassia.math.function.unary.SquareRootFunction

typealias Exponentiation = PowerFunction
typealias Fraction = DivideFunction
typealias Product = MultiplyFunction
typealias Sum = AddFunction
typealias SquareRoot = SquareRootFunction

inline fun <T> either(condition: Boolean, ifValue: T, elseValue: T): T {
	return if (condition) ifValue else elseValue
}
