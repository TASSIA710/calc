package net.tassia.calc.function.std

import net.tassia.calc.ICalculatable
import net.tassia.calc.element.poly.Sum
import net.tassia.calc.function.Function

/**
 * A [Function]-wrapper for [Sum]s.
 *
 * @since Calc 1.0
 * @author Tassilo
 */
object SumFunction : Function("add") {

	override fun invoke(args: List<ICalculatable>): ICalculatable {
		return Sum(args)
	}

}
