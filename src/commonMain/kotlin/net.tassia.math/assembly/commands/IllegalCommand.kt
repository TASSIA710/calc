package net.tassia.math.assembly.commands

import net.tassia.math.assembly.AssemblyException
import net.tassia.math.assembly.AssemblyState
import net.tassia.math.assembly.command.AssemblyCommand

internal class IllegalCommand(opCode: Int) : AssemblyCommand("ILGL", opCode) {

	override fun invoke(state: AssemblyState) {
		val code = state.commandMemory[state.address - 1]
		throw AssemblyException(state, "Invalid op-code: $code")
	}

}
