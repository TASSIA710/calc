package net.tassia.math.assembly.commands

import net.tassia.math.assembly.AssemblyState
import net.tassia.math.assembly.command.AssemblyCommand

internal class DivideCommand(opCode: Int) : AssemblyCommand("DIV", opCode) {

	override fun invoke(state: AssemblyState) {
		val address = state.readCommandMemory()
		state.accumulator /= state.getData(address)
	}

}
