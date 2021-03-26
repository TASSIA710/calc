package net.tassia.calc.function.std

import net.tassia.calc.ICalculatable
import net.tassia.calc.element.poly.Product
import net.tassia.calc.function.Function

/**
 * A [Function]-wrapper for [Product]s.
 *
 * @since Calc 1.0
 * @author Tassilo
 */
object ProductFunction : Function("mul") {

	override fun invoke(args: List<ICalculatable>): ICalculatable {
		return Product(args)
	}

}
