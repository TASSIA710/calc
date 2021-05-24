package net.tassia.math.geometry

import net.tassia.math.vector.Vector

class Line private constructor (val position: Vector, val direction: Vector) : GeometricEntity() {

	init {
		require(!direction.isZero)
	}

}
