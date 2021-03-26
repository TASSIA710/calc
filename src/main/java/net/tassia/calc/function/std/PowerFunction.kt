package net.tassia.calc.function.std

import net.tassia.calc.ICalculatable
import net.tassia.calc.element.binary.Power
import net.tassia.calc.function.Function

/**
 * A [Function]-wrapper for [Power]s.
 *
 * @since Calc 1.0
 * @author Tassilo
 */
object PowerFunction : Function("pow") {

	override fun invoke(args: List<ICalculatable>): ICalculatable {
		require(args, 2)
		return Power(args[0], args[1])
	}

}
