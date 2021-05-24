package net.tassia.math.collapse

import net.tassia.math.Calculatable

abstract class Collapsor {

	fun collapse(element: Calculatable, logger: CollapseLogger): Calculatable {
		var cache: Pair<Boolean, Calculatable>
		while (true) {
			cache = collapseElement(element, logger)
			if (!cache.first) break
		}
		return cache.second
	}

	abstract fun collapseElement(element: Calculatable, logger: CollapseLogger): Pair<Boolean, Calculatable>

}
