package com.example.fa22_bse_a.basics.callBack.main

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureNanoTime

fun main() {
    println("Here we are  -- Callbacks")
//    println("Sum = ${sum(2,5)}")

    runBlocking {

        val totalTimeTaken = measureNanoTime {
            runBlocking {
                launch {
                    sum(a = 2, b = 5, callBack = { result ->
                        println("Sum = $result")
                    })
                }


                launch {
                    div(a = 2, b = 5, callBack = { result ->
                        println("Div = $result")
                    })
                }

                launch {
                    mul(a = 2, b = 5, callBack = { result ->
                        println("Mul = $result")
                    })
                }


                launch {
                    sub(a = 2, b = 5, callBack = { result ->
                        println("Sub = $result")
                    })
                }
            }
        }
        println("Total time taken = ${totalTimeTaken/1000000000.0}")

    }




//    multiplyAndCallBack(dataList = arrayListOf(1,2,3,4,5), callBack = { multipliedResult ->
//        println("Multiplied Result = $multipliedResult")
//    })





}

suspend fun multiplyAndCallBack(dataList: List<Int>, callBack: (Int) -> Unit) {
    dataList.forEach { number ->
        delay(5000)
        callBack.invoke(number*2)
    }
}


suspend fun mul(a:Int, b: Int, callBack: (Int) -> Unit) {
    val sumResult = a*b
    delay(5000)

    callBack.invoke(sumResult)
}


suspend fun sub(a:Int, b: Int, callBack: (Int) -> Unit) {
    val sumResult = a-b
    delay(7000)

    callBack.invoke(sumResult)
}


suspend fun div(a:Int, b: Int, callBack: (Int) -> Unit) {
    val sumResult = a/b
    delay(10000)

    callBack.invoke(sumResult)
}



suspend fun sum(a:Int, b: Int, callBack: (Int) -> Unit) {
    val sumResult = a+b
    delay(12000)

    callBack.invoke(sumResult)
}

