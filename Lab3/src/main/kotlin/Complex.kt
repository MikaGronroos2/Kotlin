import kotlin.math.sqrt

const val EPS = 0.0000001 // used in equals comparison


class Complex( val real: Double, val imaginary: Double) {

    val abs: Double
        get() = sqrt((real * real + imaginary * imaginary).toDouble())

    constructor(real: Int, imaginary: Int) : this(real.toDouble(), imaginary.toDouble())

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Complex) return false

        return this.real == other.real && this.imaginary == other.imaginary
    }

    operator fun plus(other: Complex): Complex {
        return Complex((this.real+other.real), (this.imaginary+other.imaginary))

    }

    operator fun minus(other: Complex) : Complex {
        return Complex((this.real-other.real), (this.imaginary-other.imaginary))
    }

    operator fun times(other: Complex) : Complex {
        val newReal = this.real * other.real - this.imaginary * other.imaginary
        val newImaginary = this.real * other.imaginary + this.imaginary * other.real
        return Complex(newReal, newImaginary)
    }

    operator fun div(other: Complex): Complex {
        val denominator = other.real * other.real + other.imaginary * other.imaginary
        if (denominator < EPS) {
            throw ArithmeticException("Division by zero")
        }
        val realPart = (this.real * other.real + this.imaginary * other.imaginary) / denominator
        val imaginaryPart = (this.imaginary * other.real - this.real * other.imaginary) / denominator
        return Complex(realPart, imaginaryPart)
    }









}