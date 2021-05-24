package net.tassia.math.collapse

import net.tassia.math.Calculatable

fun interface CollapseLogger {

	fun onCollapse(before: Calculatable, after: Calculatable, info: String)

}
