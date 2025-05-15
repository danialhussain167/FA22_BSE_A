package com.example.fa22_bse_a.products.model

import androidx.room.Entity


@Entity(tableName = "cart_table", primaryKeys = ["id"])
data class CartItem(
    var id: String = "",
    var imageUrl: String? = "",
    var desc: String? = "",
    var companyName: String? = "",
    var price: String? = "",
    var discount: String? = "",
    var quantity: Int
)