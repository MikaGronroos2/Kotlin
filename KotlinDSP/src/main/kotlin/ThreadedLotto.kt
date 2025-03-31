package org.example

import java.util.*
import java.util.concurrent.ThreadLocalRandom
import java.util.concurrent.atomic.AtomicIntegerArray

class ThreadedLotto(val secret: Set<Int> = generateSecretNumbers()) {
    var guesses: Int = 0
    private val stats = AtomicIntegerArray(8)

    companion object {
        fun generateSecretNumbers(): Set<Int> =
            ThreadLocalRandom.current().ints(1, 41).distinct().limit(7).toArray().toSet()
    }

    fun check(numbers: List<Int>): Int {
        val correctNumbers = numbers.count { it in secret }
        stats.incrementAndGet(correctNumbers)
        guesses++
        return correctNumbers
    }

    fun getStats(): IntArray {
        return IntArray(stats.length()) { stats[it] }
    }
}

fun generateGuess(): List<Int> {
    return ThreadLocalRandom.current().ints(1, 41)
        .distinct().limit(7).toArray().toList()
}

fun main() {
    val startTime = System.currentTimeMillis()
    val lottoInstances = Collections.synchronizedList(mutableListOf<ThreadedLotto>())
    val threads: List<Thread> = (1..4).map {
        Thread {
            val lottoInstance = ThreadedLotto()
            lottoInstances.add(lottoInstance)
            (1..33750).forEach {
                val guess: List<Int> = (1..40).shuffled().take(7).toList()
                lottoInstance.check(guess)
            }
        }
    }

    threads.forEach { it.start() }
    threads.forEach { it.join() }
    lottoInstances.forEachIndexed { index, instance ->
        println("Thread $index: ${instance.guesses} guesses")
        instance.getStats().forEach { item ->
            println(item)
        }
    }

    val endTime = System.currentTimeMillis()
    val duration = endTime - startTime
    println("Total running time: $duration ms")

}