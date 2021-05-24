package net.tassia.math.assembly

import net.tassia.math.error.MathException

open class AssemblyException(

	val state: AssemblyState,
	message: String? = null, cause: Throwable? = null,

) : MathException(message, cause)
