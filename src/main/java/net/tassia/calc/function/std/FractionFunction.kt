package net.tassia.calc.function.std

import net.tassia.calc.ICalculatable
import net.tassia.calc.element.binary.Fraction
import net.tassia.calc.function.Function

/**
 * A [Function]-wrapper for [Fraction]s.
 *
 * @since Calc 1.0
 * @author Tassilo
 */
object FractionFunction : Function("div") {

	override fun invoke(args: List<ICalculatable>): ICalculatable {
		require(args, 2)
		return Fraction(args[0], args[1])
	}

}
