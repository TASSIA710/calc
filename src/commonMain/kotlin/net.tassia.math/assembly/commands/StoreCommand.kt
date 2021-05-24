package net.tassia.math.assembly.commands

import net.tassia.math.assembly.AssemblyState
import net.tassia.math.assembly.command.AssemblyCommand

internal class StoreCommand(opCode: Int) : AssemblyCommand("STORE", opCode) {

	override fun invoke(state: AssemblyState) {
		val address = state.readCommandMemory()
		state.setData(address, state.accumulator)
	}

}
