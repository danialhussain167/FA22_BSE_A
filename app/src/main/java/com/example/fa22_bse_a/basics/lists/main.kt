package com.example.fa22_bse_a.basics.lists

import java.util.Scanner

fun main() {

    val names: MutableList<String> = arrayListOf(
        "Ali",
        "Rizwan",
        "Waqas",
        "Kaif"
    )

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

    var foundFlag:Boolean = false
    for(i in 0..(names.size-1)) {
        if(names[i] == nameToSearch) {
            foundFlag = true
            println("Name found at index $i")
        }
    }

    if(!foundFlag) {
        println("Data not found")
    }

}