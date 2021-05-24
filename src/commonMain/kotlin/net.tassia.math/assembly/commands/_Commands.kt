@file:Suppress("FunctionName")
package net.tassia.math.assembly.commands

import net.tassia.math.assembly.command.AssemblyCommand

private typealias CMD = AssemblyCommand

fun ADD  (opCode: Int): CMD = AddCommand(opCode)
fun DEC  (opCode: Int): CMD = DecrementCommand(opCode)
fun DIV  (opCode: Int): CMD = DivideCommand(opCode)
fun HOLD (opCode: Int): CMD = HoldCommand(opCode)
fun ILGL (opCode: Int): CMD = IllegalCommand(opCode)
fun INC  (opCode: Int): CMD = IncrementCommand(opCode)
fun LOAD (opCode: Int): CMD = LoadCommand(opCode)
fun MUL  (opCode: Int): CMD = MultiplyCommand(opCode)
fun NOOP (opCode: Int): CMD = NoOperationCommand(opCode)
fun POW  (opCode: Int): CMD = PowerCommand(opCode)
fun STORE(opCode: Int): CMD = StoreCommand(opCode)
fun SUB  (opCode: Int): CMD = SubtractCommand(opCode)
