package com.example.fa22_bse_a.share_pref

import android.content.Context
import android.content.SharedPreferences

class SharedPreferenceHelper(context: Context) {

    val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("FA22_BSE_A", Context.MODE_PRIVATE)

    fun saveData(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun getData(key: String): String {
        return sharedPreferences.getString(key, "")!!
    }

}