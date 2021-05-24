package net.tassia.math.collapse.impl.element

import net.tassia.math.Calculatable
import net.tassia.math.collapse.CollapseLogger
import net.tassia.math.collapse.impl.ElementCollapsor
import net.tassia.math.constant.Constants
import net.tassia.math.function.binary.PowerFunction

class PowerCollapsor : ElementCollapsor<PowerFunction> {

	override fun collapse(element: PowerFunction, logger: CollapseLogger): Pair<Boolean, Calculatable> {
		return tryMultiple(element, logger, setOf(
			this::tryExponent0, this::tryExponent1
		))
	}

	private fun tryExponent0(element: PowerFunction, logger: CollapseLogger): Pair<Boolean, Calculatable>? {
		if (element.rightHand.isZero) {
			val collapsed = Constants.ONE
			logger.onCollapse(element, collapsed, "Exponent of 0")
			return true to collapsed
		}
		return null
	}

	private fun tryExponent1(element: PowerFunction, logger: CollapseLogger): Pair<Boolean, Calculatable>? {
		if (element.rightHand == Constants.ONE) {
			val collapsed = element.leftHand
			logger.onCollapse(element, collapsed, "Exponent of 1")
			return true to collapsed
		}
		return null
	}

}
