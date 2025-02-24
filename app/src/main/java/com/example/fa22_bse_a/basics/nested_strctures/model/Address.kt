package com.example.fa22_bse_a.basics.nested_strctures.model

data class Address(
    val houseNumber: String,
    val streetNumber: String,
    val blockNumber: String,
    val society: String,
    val city: City,
)
