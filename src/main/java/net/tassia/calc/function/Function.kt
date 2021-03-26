package net.tassia.calc.function

import net.tassia.calc.ICalculatable
import net.tassia.calc.MathException
import net.tassia.calc.function.std.*

/**
 * A function is something that can be invoked with `n` arguments to produce an output.
 *
 * @since Calc 1.0
 * @author Tassilo
 */
abstract class Function(val name: String) {

	/**
	 * Called when the function is invoked.
	 *
	 * @param args the arguments
	 * @return the output
	 */
	abstract operator fun invoke(args: List<ICalculatable>): ICalculatable



	/**
	 * Asserts that `args`'s size is `count`.
	 *
	 * @param args the arguments
	 * @param count the argument count
	 */
	fun require(args: List<ICalculatable>, count: Int) {
		if (args.size == count) return
		throw MathException("Function $name cannot be called with ${args.size} args ($count expected)")
	}

	/**
	 * Asserts that `args`'s size is in range `count`.
	 *
	 * @param args the arguments
	 * @param range the range
	 */
	fun require(args: List<ICalculatable>, range: IntRange) {
		if (args.size in range) return
		throw MathException("Function $name cannot be called with ${args.size} args ($range expected)")
	}



	companion object {

		/**
		 * A set containing default functions for new environments.
		 */
		val DefaultFunctions: Set<Function> = setOf(
			FractionFunction, PowerFunction, ProductFunction, RemainderFunction, SquareRootFunction, SumFunction
		)

	}

}
