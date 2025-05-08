package com.example.fa22_bse_a

import android.app.Application
import android.content.Context


class FA22BSEApplication : Application() {

    companion object {
        private var appContext: Context? = null

        fun getAppContext(): Context? {
            return appContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
    }
}