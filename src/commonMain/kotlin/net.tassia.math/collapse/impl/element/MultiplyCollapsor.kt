package net.tassia.math.collapse.impl.element

import net.tassia.math.Calculatable
import net.tassia.math.collapse.CollapseLogger
import net.tassia.math.collapse.impl.ElementCollapsor
import net.tassia.math.constant.Constants
import net.tassia.math.function.poly.MultiplyFunction

class MultiplyCollapsor : ElementCollapsor<MultiplyFunction> {

	override fun collapse(element: MultiplyFunction, logger: CollapseLogger): Pair<Boolean, Calculatable> {
		return tryMultiple(element, logger, setOf(
			this::tryEmpty, this::trySize1, this::tryMerge, this::tryStripOne, this::tryMultiplyZero, this::trySpecials
		))
	}

	private fun tryEmpty(element: MultiplyFunction, logger: CollapseLogger): Pair<Boolean, Calculatable>? {
		if (element.operands.isEmpty()) {
			val collapsed = Constants.ZERO
			logger.onCollapse(element, collapsed, "Empty Product")
			return true to collapsed
		}
		return null
	}

	private fun trySize1(element: MultiplyFunction, logger: CollapseLogger): Pair<Boolean, Calculatable>? {
		if (element.operands.size == 1) {
			val collapsed = element.operands.first()
			logger.onCollapse(element, collapsed, "Collapse Product")
			return true to collapsed
		}
		return null
	}

	private fun tryMerge(element: MultiplyFunction, logger: CollapseLogger): Pair<Boolean, Calculatable>? {
		val collapsedOperands = element.operands.filter { it !is MultiplyFunction }.toMutableList()
		val additions = element.operands.filterIsInstance<MultiplyFunction>()
		if (additions.isNotEmpty()) {
			for (addition in additions) {
				collapsedOperands.addAll(addition.operands)
			}
			val collapsed = MultiplyFunction(collapsedOperands)
			logger.onCollapse(element, collapsed, "Join Child Products")
			return true to collapsed
		}
		return null
	}

	private fun tryStripOne(element: MultiplyFunction, logger: CollapseLogger): Pair<Boolean, Calculatable>? {
		val collapsedOperands = element.operands.filter { it == Constants.ONE }
		if (collapsedOperands.size < element.operands.size) {
			val collapsed = MultiplyFunction(collapsedOperands)
			logger.onCollapse(element, collapsed, "Remove Multiplication of 1")
			return true to collapsed
		}
		return null
	}

	private fun tryMultiplyZero(element: MultiplyFunction, logger: CollapseLogger): Pair<Boolean, Calculatable>? {
		element.operands.find(Calculatable::isZero)?.run {
			val collapsed = Constants.ZERO
			logger.onCollapse(element, collapsed, "Multiplication by 0")
			return true to collapsed
		}
		return null
	}

	private fun trySpecials(element: MultiplyFunction, logger: CollapseLogger): Pair<Boolean, Calculatable>? {
		// TODO
		return null
	}

}
