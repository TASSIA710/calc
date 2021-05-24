package net.tassia.math.collapse.impl

import net.tassia.math.Calculatable
import net.tassia.math.collapse.CollapseLogger

fun interface ElementCollapsor<T : Calculatable> {

	fun collapse(element: T, logger: CollapseLogger): Pair<Boolean, Calculatable>

	fun tryMultiple(element: T, logger: CollapseLogger, options: Set<(T, CollapseLogger) -> Pair<Boolean, Calculatable>?>): Pair<Boolean, Calculatable> {
		for (option in options) {
			val result = option(element, logger)
			if (result?.first == true) return result
		}
		return false to element
	}

}
