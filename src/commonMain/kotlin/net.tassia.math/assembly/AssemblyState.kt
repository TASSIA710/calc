package net.tassia.math.assembly

import net.tassia.math.Calculatable
import net.tassia.math.assembly.command.AssemblyCommand
import net.tassia.math.assembly.commands.*
import net.tassia.math.constant.Constants

class AssemblyState(commandMemorySize: Int, dataMemorySize: Int) {

	private val commands: Array<AssemblyCommand> = arrayOf(
		ILGL (0x00), HOLD (0x01), NOOP (0x02), LOAD (0x04),
		STORE(0x05), INC  (0x06), DEC  (0x07), ADD  (0x08),
		SUB  (0x09), MUL  (0x0A), DIV  (0x0B), POW  (0x0C),
	)

	var address: Int = 0
	var isHalted: Boolean = true
	var accumulator: Calculatable = Constants.ZERO
	val statusRegister: StatusRegister = StatusRegister(this)

	val commandMemory: Array<Int> = Array(commandMemorySize) { 0 }
	val dataMemory: Array<Calculatable> = Array(dataMemorySize) { Constants.ZERO }

	init {
		// Verify commands array indices
		commands.forEachIndexed { index, command -> require(command.opCode == index) }
	}



	fun start(address: Int = 0) {
		try {
			// Reset state
			this.address = address
			this.isHalted = false
			this.accumulator = Constants.ZERO

			// Start reading commands
			while (!isHalted) {
				val cmd = readCommand()
				cmd.invoke(this)
			}
		} catch (ex: Throwable) {
			throw AssemblyException(this, "An error occurred while executing the assembly program.", ex)
		}
	}



	@Suppress("NOTHING_TO_INLINE")
	inline fun readCommandMemory(): Int {
		address %= commandMemory.size
		return commandMemory[address++]
	}

	fun readCommand(): AssemblyCommand {
		val id = readCommandMemory()
		return if (id >= commands.size) {
			commands[0]
		} else {
			commands[id]
		}
	}



	@Suppress("NOTHING_TO_INLINE")
	inline fun getData(address: Int): Calculatable {
		return if (address < dataMemory.size) dataMemory[address] else Constants.ZERO
	}

	@Suppress("NOTHING_TO_INLINE")
	inline fun setData(address: Int, data: Calculatable) {
		if (address < dataMemory.size) {
			dataMemory[address] = data
		} else {
			throw AssemblyException(this, "Cannot write to memory-address 0x${address.toString(16)}, because data memory is not large enough.")
		}
	}

}
