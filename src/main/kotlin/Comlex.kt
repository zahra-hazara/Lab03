package org.example
import kotlin.math.abs
import kotlin.math.sqrt

const val EPS = 0.0000001 // used in equals comparison

class Complex(val real: Double, val imaginary: Double) {
    // Secondary constructors for integer inputs
    constructor(real: Int, imaginary: Int) : this(real.toDouble(), imaginary.toDouble())

    // Abs property to calculate magnitude
    val abs: Double
        get() = sqrt(real * real + imaginary * imaginary)

    // Operator overloading for addition
    operator fun plus(other: Complex) = Complex(real + other.real, imaginary + other.imaginary)

    // Operator overloading for subtraction
    operator fun minus(other: Complex) = Complex(real - other.real, imaginary - other.imaginary)

    // Operator overloading for multiplication
    operator fun times(other: Complex): Complex = Complex(
        real * other.real - imaginary * other.imaginary,
        real * other.imaginary + imaginary * other.real
    )

    // Override equals for structural comparison
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Complex) return false
        return abs(real - other.real) < EPS && abs(imaginary - other.imaginary) < EPS
    }

    // Override hashCode to be consistent with equals
    override fun hashCode(): Int {
        var result = real.hashCode()
        result = 31 * result + imaginary.hashCode()
        return result
    }

    // Override toString for easier debugging
    override fun toString(): String = "$real + ${imaginary}i"
}