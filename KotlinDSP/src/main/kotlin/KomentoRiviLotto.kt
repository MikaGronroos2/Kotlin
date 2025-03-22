package org.example

fun guessedNumbers(s: String?): List<Int>? {
    val parsedString = s?.replace("[^0-9,]".toRegex(), "")
    return parsedString?.split(",")?.mapNotNull { it.toIntOrNull() }
}

fun isLegalGuess(guess: List<Int>?): Boolean{
    val listOfWrongItems = mutableListOf<Int>()

    guess?.forEach({ item ->
        if (item > 40) {
            listOfWrongItems.add(item)
        }
    })

    guess?.let {
        val uniqueItems = mutableSetOf<Int>()
        for (item in it) {
            if (!uniqueItems.add(item)) {
                println("Multiple same numbers found, returning false")
                return false
            }
        }
    }

    if (listOfWrongItems.size > 0) {
        println("Illegal numbers found: $listOfWrongItems")
        return false
    }

    if ( (guess?.size ?: 0) == 7) {
        return true
    }

    else {
        val sizeOfList = guess?.size
        return false
    }

}

fun equalsCount(a: List<Int>?, b: List<Int>?): Int {
    val equalsList= mutableListOf<Int>()

    a?.forEach({ item ->
        if (b?.contains(item) == true) {
            equalsList.add(item)
        }
    })

    val equalsCounter: Int = equalsList.size

    return equalsCounter
}

fun playGame(secret: List<Int>,guessString: String): Boolean {
    val guessList = guessedNumbers(guessString)

    if (isLegalGuess(guessList)) {
        val count = equalsCount(secret, guessList)
        if (count == 7) {
            return true
        } else {
            return false
        }
    }
    else return false
}

fun main() {
    val secret = (1..40).shuffled().take(7)
    println("Secret list: $secret")

    while (true) {
        println("Input guess for the lotto")
        val userInput = readlnOrNull()
        if (userInput != null) {

            if (userInput == "quit") {
                break
            }

            println(userInput)
            if (playGame(secret,userInput)) {
                println("Congratulations you guessed the lotto correctly!!!")
                println("The winning numbers are ${guessedNumbers(userInput)}")
                break
            } else {
                println("Unfortunately only ${equalsCount(secret,guessedNumbers(userInput))}")
            }
        } else {
            println("No input received")
        }
    }
    println("Exiting the game...")
}