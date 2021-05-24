package net.tassia.math.assembly.commands

import net.tassia.math.assembly.AssemblyState
import net.tassia.math.assembly.command.AssemblyCommand

internal class PowerCommand(opCode: Int) : AssemblyCommand("POW", opCode) {

	override fun invoke(state: AssemblyState) {
		val address = state.readCommandMemory()
		state.accumulator = state.accumulator pow state.getData(address)
	}

}
