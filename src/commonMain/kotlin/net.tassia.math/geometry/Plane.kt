package net.tassia.math.geometry

import net.tassia.math.vector.Vector

class Plane private constructor (val position: Vector, val normal: Vector) : GeometricEntity() {

	init {
		require(normal.isNormalized)
	}

}
