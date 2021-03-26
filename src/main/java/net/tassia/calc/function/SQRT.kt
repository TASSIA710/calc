package net.tassia.calc.function

import net.tassia.calc.ICalculatable
import net.tassia.calc.Math
import net.tassia.calc.MathException
import net.tassia.calc.element.DecimalValue

/**
 * Used to calculate the square root of a number.
 *
 * @since Calc 1.0
 * @author Tassilo
 *
 * @see Math.sqrt
 */
object SQRT : Function("sqrt", 1..1) {

	override fun evaluate(args: List<ICalculatable>): ICalculatable {
		assert(args.size == 1)

		val value = args[0].evaluateDouble()
		if (value < 0) throw MathException("Cannot calculate square root of ${args[0]} (actual: $value)")

		return DecimalValue(Math.sqrt(value))
	}

}
