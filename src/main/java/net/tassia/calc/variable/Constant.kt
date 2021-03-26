package net.tassia.calc.variable

import net.tassia.calc.ICalculatable
import net.tassia.calc.element.DecimalValue

/**
 * A constant is a special variable whose value may never change.
 *
 * @param name the name of the variable
 * @param value the value of the variable
 *
 * @since Calc 1.0
 * @author Tassilo
 *
 * @see Variable
 */
class Constant(override val name: String, val value: Double) : Variable(name) {

	override fun evaluate(): ICalculatable = DecimalValue(value)



	companion object {

		/**
		 * The PI constant.
		 *
		 * `3.14159265358979323846`
		 */
		val PI = Constant("pi", Math.PI)

		/**
		 * The E constant.
		 *
		 * `2.7182818284590452354`
		 */
		val E = Constant("e", Math.E)

		// TODO: I
		// TODO: Feigenbaum Constants
		// TODO: Golden Ratio

	}

}
