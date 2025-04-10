package org.example

import kotlin.math.max
import kotlin.math.min


class Car(val maxSpeed: Double = 120.0, val gasolineCapacity: Double = 50.0) {
    var gasolineLevel: Double = 0.0
        private set

    var speed: Double = 0.0
        private set

    fun fillTank() {
        gasolineLevel = gasolineCapacity
    }

    fun accelerate() {
        val newSpeed = min(speed + 1.0, maxSpeed)
        val gasolineNeeded = (newSpeed - speed) * 0.1
        if (gasolineLevel >= gasolineNeeded) {
            gasolineLevel -= gasolineNeeded
            speed = newSpeed
            println("This cars current speed is $speed mp/h")
        }
        println("This cars current speed is $speed mp/h")
    }

    fun decelerate() {
        speed = max(speed - 1.5, 0.0)
    }
}


fun main() {
    val c1 = Car()
    val c2 = Car(120.0)
    val c3 = Car(120.0, 50.0)
    val c5 = Car(maxSpeed = 120.0, gasolineCapacity = 50.0)

    c1.fillTank()

    for(i in 1..120){
        c1.accelerate()
    }

    while(c1.speed > 0){
        c1.decelerate()
    }
}