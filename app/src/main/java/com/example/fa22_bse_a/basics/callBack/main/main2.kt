package com.example.fa22_bse_a.basics.callBack.main

fun main() {

    sum2(a = 40, b= 60, c = 10, startCallBack = { message ->
        println(message)
    }, inProgressCallBack = {message ->
        println(message)
    },  finishCallBack = { result ->
        println("Sum = $result")
    })


}

fun sum2(a:Int, b:Int, c:Int, startCallBack: (String)->Unit, inProgressCallBack: (String) ->Unit, finishCallBack: (Int) -> Unit) {
    startCallBack.invoke("Process Started")
    val firstResult = a + b

    inProgressCallBack.invoke("In progress")

    val finalResult = firstResult + c
    finishCallBack.invoke(finalResult)
}
