package com.example.fa22_bse_a.products.model

// Model Layer
data class Product(
    var id: String = "",
    var imageIrl: String? = "",
    var desc: String? = "",
    var companyName: String? = "",
    var price: String? = "",
    var discount: String? = ""
)