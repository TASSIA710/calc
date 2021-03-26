package net.tassia.calc.variable

import net.tassia.calc.calc

/**
 * Utility object containing common [Constant]s.
 *
 * @since Calc 1.0
 * @author Tassilo
 */
object Constants {

	/**
	 * The number `e`, also known as Euler's number, is a mathematical constant approximately equal to `2.71828`,
	 * and can be characterized in many ways. It is the base of the natural logarithm. It is the limit of `(1 + 1/n)^n`
	 * as `n` approaches infinity, an expression that arises in the study of compound interest.
	 * It can also be calculated as the sum of the infinite series.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/E_(mathematical_constant)">Euler's number</a>
	 */
	val E = Constant("e", Math.E.calc())

	/**
	 * The number `π` is a mathematical constant. It is defined as the ratio of a circle's circumference to its
	 * diameter, and it also has various equivalent definitions. It appears in many formulas in all areas of
	 * mathematics and physics. The earliest known use of the Greek letter `π` to represent the ratio of a circle's
	 * circumference to its diameter was by Welsh mathematician William Jones in 1706. It is approximately equal
	 * to `3.14159`. It has been represented by the Greek letter `π` since the mid-18th century, and is spelled
	 * out as "pi". It is also referred to as Archimedes' constant.
	 *
	 * @see <a href="https://en.wikipedia.org/wiki/Pi">Archimedes' constant</a>
	 */
	val PI = Constant("pi", Math.PI.calc())

}
