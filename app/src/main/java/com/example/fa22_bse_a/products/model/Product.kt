package com.example.fa22_bse_a.products.model

import androidx.recyclerview.widget.RecyclerView

data class Product(
    val imageIrl: String?,
    val desc: String?,
    val companyName: String?,
    var price: Double?,
    val discount: Double?,
    val quantity: Int
)