import kotlin.random.Random

class Lotto {
    private val secret = (1..40).toList().shuffled().take(7).sorted()

    fun check(numbers: List<Int>): Int {
        if (numbers.all { it in (1..40) } && numbers.toSet().size == 7) {
            return numbers.intersect(secret).size
        } else {
            return 0
        }
    }

    fun makeLotteryTicket(): List<Int> {
        val lotteryTicket = (1..40).toList().shuffled().take(7).sorted()
        return lotteryTicket
    }


    fun makeBetterLotteryTicket(workingNumbers: List<Int>): List<Int> {

    }

}
fun main(){
    val lotto: Lotto = Lotto()

    for (i in 1..100) {
        var lotteryTicket: List<Int> = lotto.makeLotteryTicket()
        print(lotteryTicket)
        var correctNumbers = lotto.check(lotteryTicket)

        if(correctNumbers > 0) {

        }
    }





}
