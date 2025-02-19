package com.example.fa22_bse_a.basics.control_block

import java.util.Scanner

fun main() {
    println("Here we are -- Control Block")

    val grade: Char?
    println("Enter your Grade")
    grade = Scanner(System.`in`).nextLine().uppercase().getOrNull(0)//.get(0)//[0]  //

    when(grade) {
        'A' -> {
            print("Excelent")
        }
        'B' -> {
            print("Good")
        }
        'C' -> {
            print("Perha kro")
        }
        'D' -> {
            print("Next time DI ho jao gy")
        }
        else -> {
            print("Ja ja tur ja")
        }

    }


}