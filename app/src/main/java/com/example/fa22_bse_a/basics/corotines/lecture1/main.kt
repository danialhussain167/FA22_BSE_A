package com.example.fa22_bse_a.basics.corotines.lecture1

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    val startTime = System.currentTimeMillis()
    runBlocking {
        delay(1000)
        launch {
            add()
        }
        delay(1000)
        launch {
            sub()
        }
        delay(2000)
        launch {
            downloadFile()
        }
        delay(2000)
        launch {
            task()
        }
    }
    val endTime = System.currentTimeMillis()
    println("Total time consumed is = ${(endTime.toDouble() - startTime.toDouble()) / 1000.0} s")
}


suspend fun add(): Int {
    delay(2000)
    return 1 + 2
}

suspend fun sub(): Int {
    delay(3000)
    return 1 - 2
}

suspend fun downloadFile(): String {
    print("sdmncjnds")
    delay(4000)
    return "file.png"
}

suspend fun task(): String {
    delay(2000)
    return "Daniyal's habbits are like pakhiiwasss"
}