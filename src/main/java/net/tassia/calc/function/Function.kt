package net.tassia.calc.function

import net.tassia.calc.ICalculatable

// TODO: abs
// TODO: acos
// TODO: acosh
// TODO: asin
// TODO: asinh
// TODO: atan
// TODO: atan2
// TODO: atanh
// TODO: cbrt
// TODO: ceil
// TODO: cos
// TODO: cosh
// TODO: exp
// TODO: expm1
// TODO: floor
// TODO: hypot
// TODO: ln
// TODO: ln1p
// TODO: log
// TODO: log10
// TODO: log2
// TODO: max
// TODO: min
// TODO: rand
// TODO: root
// TODO: round
// TODO: sin
// TODO: sinh
// TODO: tan
// TODO: tanh
// TODO: truncate
// TODO: pow
// TODO: round

/**
 * A function is something that can be called with `n` arguments to produce an output.
 *
 * @since Calc 1.0
 * @author Tassilo
 */
abstract class Function (

	/**
	 * The name of this function.
	 */
	val name: String,

	/**
	 * The amount of arguments this function takes.
	 */
	val argCount: IntRange,

) {

	/**
	 * Invoked when the function is called.
	 *
	 * @param args the arguments
	 * @return the output
	 */
	abstract fun evaluate(args: List<ICalculatable>): ICalculatable

}
