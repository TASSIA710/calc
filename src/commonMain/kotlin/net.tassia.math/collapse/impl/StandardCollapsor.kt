package net.tassia.math.collapse.impl

import net.tassia.math.Calculatable
import net.tassia.math.collapse.CollapseLogger
import net.tassia.math.collapse.Collapsor
import net.tassia.math.collapse.impl.element.*
import net.tassia.math.function.binary.DivideFunction
import net.tassia.math.function.binary.PowerFunction
import net.tassia.math.function.poly.AddFunction
import net.tassia.math.function.poly.MultiplyFunction
import net.tassia.math.function.unary.SquareRootFunction

object StandardCollapsor : Collapsor() {

	private val addCollapsor = AddCollapsor()
	private val divideCollapsor = DivideCollapsor()
	private val multiplyCollapsor = MultiplyCollapsor()
	private val powerCollapsor = PowerCollapsor()
	private val squareRootCollapsor = SquareRootCollapsor()

	override fun collapseElement(element: Calculatable, logger: CollapseLogger): Pair<Boolean, Calculatable> {
		return when (element) {
			is AddFunction -> addCollapsor.collapse(element, logger)
			is DivideFunction -> divideCollapsor.collapse(element, logger)
			is MultiplyFunction -> multiplyCollapsor.collapse(element, logger)
			is PowerFunction -> powerCollapsor.collapse(element, logger)
			is SquareRootFunction -> squareRootCollapsor.collapse(element, logger)
			else -> false to element
		}
	}

}
