import org.junit.jupiter.api.Test
import kotlin.math.abs
import kotlin.math.sqrt

internal class ComplexTest {
    @Test
    fun testConstructor1() {
        val a = Complex(1.0, 2.0)
        assert(((a.real / 1.0 - 1.0) < EPS) && ((a.imaginary / 2.0 - 1.0) < EPS))
    }

    @Test
    fun testConstructor2() {
        val a = Complex(1, 2)
        assert((abs(a.real / 1.0 - 1.0) < EPS) && (abs(a.imaginary / 2.0 - 1.0) < EPS))
    }

    @Test
    fun testEquals1() {
        val a = Complex(1, 2)
        val b = Complex(1, 2)
        assert(a == b)
    }



}