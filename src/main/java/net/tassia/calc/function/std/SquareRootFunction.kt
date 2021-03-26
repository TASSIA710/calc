package net.tassia.calc.function.std

import net.tassia.calc.ICalculatable
import net.tassia.calc.element.unary.SquareRoot
import net.tassia.calc.function.Function

/**
 * A [Function]-wrapper for [SquareRoot]s.
 *
 * @since Calc 1.0
 * @author Tassilo
 */
object SquareRootFunction : Function("sqrt") {

	override fun invoke(args: List<ICalculatable>): ICalculatable {
		require(args, 1)
		return SquareRoot(args[0])
	}

}
