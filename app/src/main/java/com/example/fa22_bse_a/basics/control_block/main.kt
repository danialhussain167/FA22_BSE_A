package com.example.fa22_bse_a.basics.control_block

import java.util.Scanner

fun main() {
    println("Here we are -- Control Block")

    val age: Int?
    println("Enter your Age")

    age = Scanner(System.`in`).nextLine().toIntOrNull()//.get(0)//[0]  //

    when(age) {
        in (1..20) -> {
            // Code to execute when age is between 1 and 20
            println("Enjoy")
        }
        in (21 .. 40) -> {
            println("Count Down started")
        }
        in (100 .. 10000) -> {
            println("You are a snake")
        }
        else -> {
            // Code to execute for all other cases
            println("Age is outside the 1 to 20 range")
        }
    }
//    val grade: Char?
//    println("Enter your Grade")
//    grade = Scanner(System.`in`).nextLine().uppercase().getOrNull(0)//.get(0)//[0]  //
//
//    when(grade) {
//        'A' -> {
//            print("Excelent")
//        }
//        'B' -> {
//            print("Good")
//        }
//        'C' -> {
//            print("Perha kro")
//        }
//        'D' -> {
//            print("Next time DI ho jao gy")
//        }
//        else -> {
//            print("Ja ja tur ja")
//        }
//
//    }


}