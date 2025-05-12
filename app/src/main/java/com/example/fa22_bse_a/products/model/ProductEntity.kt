package com.example.fa22_bse_a.products.model

import androidx.room.Entity

// Model Layer

@Entity(tableName = "product_table", primaryKeys = ["id"])
data class ProductEntity(
    var id: String = "",
    var imageIrl: String? = "",
    var desc: String? = "",
    var companyName: String? = "",
    var price: String? = "",
    var discount: String? = ""
)