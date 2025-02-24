package com.example.fa22_bse_a.basics.nested_strctures.model

data class City(
    val name: String,
    val postalCode: List<String>
) {
    fun getCityName(): String {
        return "CityName is : $name"
    }
}
