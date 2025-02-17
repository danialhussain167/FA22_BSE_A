package com.example.fa22_bse_a.basics.classes.main

import com.example.fa22_bse_a.basics.classes.model.StudentModel
import java.util.Scanner


fun main() {
    println("Topic -- classes")
    val student1: StudentModel = StudentModel(
        address = "Vehari",
        name = "Anas",
        age = 20
    )
//    println("Name: ${student1.name}, Age: ${student1.age}, Address: ${student1.address}")
    displayStudent(student1)
    val student2: StudentModel = student1.copy(age = 21)
    displayStudent(student2)
    val userCreatedStudent:StudentModel = createStudent()
    displayStudent(userCreatedStudent)
}

fun displayStudent(student: StudentModel) {
    with(student) {
        println("Name: ${name}, Age: ${age}, Address: ${address}")
    }
}

fun createStudent():StudentModel {
    val sc: Scanner = Scanner(System.`in`)
    print("Enter Student Name")
    val newName: String = sc.nextLine()
    print("Enter Student Age")
    val newAge: Int = sc.nextLine().toInt()
    print("Enter Student Address")
    val newAddress: String = sc.nextLine()
    return StudentModel(name = newName, age = newAge, address = newAddress)
}