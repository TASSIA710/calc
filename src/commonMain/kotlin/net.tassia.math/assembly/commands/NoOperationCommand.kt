package net.tassia.math.assembly.commands

import net.tassia.math.assembly.AssemblyState
import net.tassia.math.assembly.command.AssemblyCommand

internal class NoOperationCommand(opCode: Int) : AssemblyCommand("NOOP", opCode) {

	override fun invoke(state: AssemblyState) {
		// Do nothing
	}

}
