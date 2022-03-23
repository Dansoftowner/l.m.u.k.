package org.lmuk.analyticgeometry

import kotlin.math.*

data class Vector(val x: Double, val y: Double) {

    val length: Double get() = sqrt(x.pow(2) + y.pow(2))

    /**
     * Performs a scalar product on two vectors
     */
    operator fun times(other: Vector): Double = x * other.x + y * other.y

    /**
     * Calculates the pitch of two vectors in radians.
     */
    fun pitch(other: Vector): Double {
        return acos(abs(this * other) / (length * other.length))
    }

}