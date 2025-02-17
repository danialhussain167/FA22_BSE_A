package com.example.fa22_bse_a.basics

fun main() {

    var a:Int? = null// nullable integer
//    a = 30
    var b:Int? = 40

    var sum = (a?:0) + (b?:0) // else-wise operator

    print("Sum  = $sum  \n")

    print("div = ${(a?:0)/(b?:1)}  \n")
}