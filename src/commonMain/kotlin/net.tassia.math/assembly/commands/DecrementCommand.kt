package net.tassia.math.assembly.commands

import net.tassia.math.assembly.AssemblyState
import net.tassia.math.assembly.command.AssemblyCommand

internal class DecrementCommand(opCode: Int) : AssemblyCommand("DEC", opCode) {

	override fun invoke(state: AssemblyState) {
		state.accumulator--
	}

}
