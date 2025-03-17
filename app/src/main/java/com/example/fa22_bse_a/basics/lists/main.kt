package com.example.fa22_bse_a.basics.lists

import com.example.fa22_bse_a.basics.lists.model.Teacher
import java.util.Scanner

fun main() {

    val teachers: List<Teacher> = arrayListOf(
        Teacher(name = "Dr. Javed Ferzund", department = "SE", age = 20),
        Teacher(name = "Ahmad Shaf", department = "CS", age = 30),
        Teacher(name = "Ali Usman", department = "SE", age = 50),
        Teacher(name = "Muhammad Aamir Aslam", department = "CS", age = 32),
        Teacher(name = "Asim Noon", department = "EE", age = 42),
        Teacher(name = "Shakir", department = "CVE", age = 39),
        Teacher(name = "Snoia Abbas", department = "BBA", age = 27)
    )
    val csTeachers_usingFind = teachers.filter { it.department == "CS" && it.age > 30 }
    val seTeachers_usingFilter = teachers.filter { it.department == "SE" }

    println("CS Teachers csTeachers_usingFilter -> $csTeachers_usingFind")
    println("SE Teachers seTeachers_usingFilter -> ${seTeachers_usingFilter}")






//    println("Filtered Teachers = ${
//        teachers.filter { filterByTeacherProperties(it) }
//    }")





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

fun filterByTeacherProperties(teacher: Teacher): Boolean {
    return teacher.name.length > 3 && !teacher.department.contains("a") && teacher.age < 700000
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