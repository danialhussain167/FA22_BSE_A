package com.example.fa22_bse_a.app_local_database.data_base

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.fa22_bse_a.FA22BSEApplication
import com.example.fa22_bse_a.app_local_database.dao.CartDao
import com.example.fa22_bse_a.app_local_database.dao.LoginDao
import com.example.fa22_bse_a.app_local_database.dao.ProductDao
import com.example.fa22_bse_a.login_migrated.model.LoginEntity
import com.example.fa22_bse_a.products.model.CartItem
import com.example.fa22_bse_a.products.model.ProductEntity

@Database(entities = [LoginEntity::class, ProductEntity::class, CartItem::class], version = 2)
abstract class LocalDataBase : RoomDatabase() {

    abstract fun getLoginEntityDao(): LoginDao
    abstract fun getProductDao(): ProductDao
    abstract fun getCartDao(): CartDao

    companion object {
        private var instance: LocalDataBase? = null //  instance is same like object

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