const val EPS = 0.0000001 // used in equals comparison


class Complex( val real: Double, val imaginary: Double) {



    constructor(real: Int, imaginary: Int) : this(real.toDouble(), imaginary.toDouble())
}