package com.example.fa22_bse_a.basics.lists

import java.util.Scanner

fun main() {



//    val names: MutableList<String> = arrayListOf(
//        "Ali",
//        "RIZWAN",
//        "WAQAS",
//        "KAIF",
//        "Own"
//    )
//
//    val namesWithA = names.filter { it.contains("A") }
//    val totalNamesWithA = names.filter { it.contains("A") }  .size
//
//    println("namesWithA -> $namesWithA")
//    println("totalNamesWithA -> $totalNamesWithA")

//    val ages: List<Int> = arrayListOf(
//        1, 2, 3, 4, 5, 6, 7, 8, 9, 10
//    )
//    val oddList = ages.filter { (it%2)!=0 }
//    val evenList = ages.filter { (it%2)==0 }
//    println(oddList)
//    println(evenList)

//    search(names)

//    names.forEach { name ->
//        println(name)
//    }

//    for(i in 0..3) {
//        println(names[i])
//    }


//
//    names.add("Usman")
//    names.add(0,"Kashif")
//    println(names[0])


}

fun search(names: List<String>) {
    val sc: Scanner = Scanner(System.`in`)
    println("Enter the name to search")
    val nameToSearch: String = sc.nextLine()

    var foundFlag: Boolean = false
    for (i in 0..(names.size - 1)) {
        if (names[i] == nameToSearch) {
            foundFlag = true
            println("Name found at index $i")
        }
    }

    if (!foundFlag) {
        println("Data not found")
    }

}