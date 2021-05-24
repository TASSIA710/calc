package net.tassia.math.assembly.commands

import net.tassia.math.assembly.AssemblyState
import net.tassia.math.assembly.command.AssemblyCommand

internal class HoldCommand(opCode: Int) : AssemblyCommand("HOLD", opCode) {

	override fun invoke(state: AssemblyState) {
		state.isHalted = true
	}

}
