package com.example.fa22_bse_a.basics.nested_strctures.main

import com.example.fa22_bse_a.basics.nested_strctures.model.Address
import com.example.fa22_bse_a.basics.nested_strctures.model.City
import com.example.fa22_bse_a.basics.nested_strctures.model.Date
import com.example.fa22_bse_a.basics.nested_strctures.model.Email
import com.example.fa22_bse_a.basics.nested_strctures.model.Name
import com.example.fa22_bse_a.basics.nested_strctures.model.RegistrationNumber
import com.example.fa22_bse_a.basics.nested_strctures.model.Student

fun main() {

    println("Here we are -- In nested Structures")

    val student: Student = Student(
        name = Name(fName = "Kaif", mName = "Rao", lName = "Nan Channy waly"),
        dob = Date(day = "1", month = "1", year = "712"),
        address = Address(houseNumber = "101", streetNumber = "201", blockNumber = "A1", society = "Royal Orchard", city = City(name = "Sahiwal", postalCode = arrayListOf("11111"))),
        email = Email(userName = "kaif712", domain = "gmail.com"),
        registrationNumber = RegistrationNumber(session = "FA22", department = "BSE", rollNumber = "031")
    )
//    println("Student = ${student.toString()}")


    println(arrayListOf(student).filter { st -> st.address.city.name == "Sahiwal" })
}