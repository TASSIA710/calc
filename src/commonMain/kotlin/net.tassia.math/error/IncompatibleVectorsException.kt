package net.tassia.math.error

import net.tassia.math.vector.Vector

open class IncompatibleVectorsException(

	val vector1: Vector, val vector2: Vector,
	message: String? = null, cause: Throwable? = null,

) : MathException(message, cause)
