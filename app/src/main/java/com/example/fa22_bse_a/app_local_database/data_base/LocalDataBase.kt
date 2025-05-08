package com.example.fa22_bse_a.app_local_database.data_base

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.fa22_bse_a.FA22BSEApplication
import com.example.fa22_bse_a.app_local_database.dao.LoginDao
import com.example.fa22_bse_a.login_migrated.model.LoginEntity

@Database(entities = [LoginEntity::class], version = 1)
abstract class LocalDataBase : RoomDatabase() {

    abstract fun getLoginEntityDao(): LoginDao

    companion object {
        var instance: LocalDataBase? = null //  instance is same like object

        @JvmName("getInstanceABC")
        fun getInstance(): LocalDataBase {
            if (instance == null) {
                return Room.databaseBuilder(
                    FA22BSEApplication.getAppContext()!!,
                    LocalDataBase::class.java,
                    name = "FA22_BSE_A"
                ).build()
            } else {
                return instance!!
            }
        }
    }


}