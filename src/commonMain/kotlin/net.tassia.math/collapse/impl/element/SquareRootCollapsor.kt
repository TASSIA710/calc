package net.tassia.math.collapse.impl.element

import net.tassia.math.Calculatable
import net.tassia.math.collapse.CollapseLogger
import net.tassia.math.collapse.impl.ElementCollapsor
import net.tassia.math.constant.Constants
import net.tassia.math.function.unary.SquareRootFunction

class SquareRootCollapsor : ElementCollapsor<SquareRootFunction> {

	override fun collapse(element: SquareRootFunction, logger: CollapseLogger): Pair<Boolean, Calculatable> {
		return tryMultiple(element, logger, setOf(
			this::tryBase0
		))
	}

	private fun tryBase0(element: SquareRootFunction, logger: CollapseLogger): Pair<Boolean, Calculatable>? {
		if (element.operand.isZero) {
			val collapsed = Constants.ZERO
			logger.onCollapse(element, collapsed, "Base of 0")
			return true to collapsed
		}
		return null
	}

}
