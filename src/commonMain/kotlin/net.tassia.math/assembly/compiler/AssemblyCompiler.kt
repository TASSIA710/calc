package net.tassia.math.assembly.compiler

abstract class AssemblyCompiler {

	@Throws(AssemblyCompilationException::class)
	abstract fun compile(source: String, bufferSize: Int = 4096): ByteArray

}
