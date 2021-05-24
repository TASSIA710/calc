package net.tassia.math.collapse.impl.element

import net.tassia.math.Calculatable
import net.tassia.math.collapse.CollapseLogger
import net.tassia.math.collapse.impl.ElementCollapsor
import net.tassia.math.constant.Constants
import net.tassia.math.function.binary.DivideFunction

class DivideCollapsor : ElementCollapsor<DivideFunction> {

	override fun collapse(element: DivideFunction, logger: CollapseLogger): Pair<Boolean, Calculatable> {
		return tryMultiple(element, logger, setOf(
			this::tryDivideBy1
		))
	}

	private fun tryDivideBy1(element: DivideFunction, logger: CollapseLogger): Pair<Boolean, Calculatable>? {
		if (element.rightHand == Constants.ONE) {
			val collapsed = element.leftHand
			logger.onCollapse(element, collapsed, "Division by 1")
			return true to collapsed
		}
		if (element.rightHand == Constants.NEGATIVE_ONE) {
			val collapsed = -element.leftHand
			logger.onCollapse(element, collapsed, "Division by -1")
			return true to collapsed
		}
		return null
	}

}
