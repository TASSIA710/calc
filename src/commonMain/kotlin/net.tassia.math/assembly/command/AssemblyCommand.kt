package net.tassia.math.assembly.command

import net.tassia.math.assembly.AssemblyState

abstract class AssemblyCommand(val name: String, val opCode: Int) {

	abstract fun invoke(state: AssemblyState)

}
