import org.example.equalsCount
import org.example.guessedNumbers
import org.example.isLegalGuess
import org.example.playGame
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class KomentoRiviLottoTest {

    @Test
    fun testGuessedNumbers() {
        assertEquals(listOf(1, 2, 3, 4, 5, 6, 7), guessedNumbers("1,2,3,4,5,6,7"))
        assertEquals(listOf(1, 2, 3), guessedNumbers("1,2,3,a,b,c"))
        assertEquals(null, guessedNumbers(null))
    }

    @Test
    fun testIsLegalGuess() {
        assertTrue(isLegalGuess(listOf(1, 2, 3, 4, 5, 6, 7)))
        assertFalse(isLegalGuess(listOf(1, 2, 3, 4, 5, 6, 41)))
        assertFalse(isLegalGuess(listOf(1, 2, 3, 4, 5, 6, 6)))
        assertFalse(isLegalGuess(listOf(1, 2, 3)))
    }

    @Test
    fun testEqualsCount() {
        assertEquals(3, equalsCount(listOf(1, 2, 3), listOf(1, 2, 3, 4, 5)))
        assertEquals(0, equalsCount(listOf(1, 2, 3), listOf(4, 5, 6)))
        assertEquals(0, equalsCount(null, listOf(1, 2, 3)))
    }

    @Test
    fun testPlayGame() {
        val secret = listOf(1, 2, 3, 4, 5, 6, 7)
        assertTrue(playGame(secret, "1,2,3,4,5,6,7"))
        assertFalse(playGame(secret, "1,2,3,4,5,6,8"))
        assertFalse(playGame(secret, "1,2,3,4,5,6"))
    }
}