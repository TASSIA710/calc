package net.tassia.math.collapse.impl.element

import net.tassia.math.Calculatable
import net.tassia.math.collapse.CollapseLogger
import net.tassia.math.collapse.impl.ElementCollapsor
import net.tassia.math.constant.Constants
import net.tassia.math.function.poly.AddFunction

class AddCollapsor : ElementCollapsor<AddFunction> {

	override fun collapse(element: AddFunction, logger: CollapseLogger): Pair<Boolean, Calculatable> {
		return tryMultiple(element, logger, setOf(
			this::tryEmpty, this::trySize1, this::tryMerge, this::tryStripZero, this::trySpecials
		))
	}

	private fun tryEmpty(element: AddFunction, logger: CollapseLogger): Pair<Boolean, Calculatable>? {
		if (element.operands.isEmpty()) {
			val collapsed = Constants.ZERO
			logger.onCollapse(element, collapsed, "Empty Sum")
			return true to collapsed
		}
		return null
	}

	private fun trySize1(element: AddFunction, logger: CollapseLogger): Pair<Boolean, Calculatable>? {
		if (element.operands.size == 1) {
			val collapsed = element.operands.first()
			logger.onCollapse(element, collapsed, "Collapse Sum")
			return true to collapsed
		}
		return null
	}

	private fun tryMerge(element: AddFunction, logger: CollapseLogger): Pair<Boolean, Calculatable>? {
		val collapsedOperands = element.operands.filter { it !is AddFunction }.toMutableList()
		val additions = element.operands.filterIsInstance<AddFunction>()
		if (additions.isNotEmpty()) {
			for (addition in additions) {
				collapsedOperands.addAll(addition.operands)
			}
			val collapsed = AddFunction(collapsedOperands)
			logger.onCollapse(element, collapsed, "Join Child Sums")
			return true to collapsed
		}
		return null
	}

	private fun tryStripZero(element: AddFunction, logger: CollapseLogger): Pair<Boolean, Calculatable>? {
		val collapsedOperands = element.operands.filter { !it.isZero }
		if (collapsedOperands.size < element.operands.size) {
			val collapsed = AddFunction(collapsedOperands)
			logger.onCollapse(element, collapsed, "Remove Addition of 0")
			return true to collapsed
		}
		return null
	}

	private fun trySpecials(element: AddFunction, logger: CollapseLogger): Pair<Boolean, Calculatable>? {
		// TODO
		return null
	}

}
