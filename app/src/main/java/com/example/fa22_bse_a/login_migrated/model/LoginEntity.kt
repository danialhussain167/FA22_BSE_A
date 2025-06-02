package com.example.fa22_bse_a.login_migrated.model

import androidx.room.ColumnInfo
import androidx.room.Entity


@Entity(tableName = "login_table", primaryKeys = ["email"])
data class LoginEntity(
    @ColumnInfo("name") var name: String,
    @ColumnInfo("email") val email: String,
    @ColumnInfo("password") val password: String
)