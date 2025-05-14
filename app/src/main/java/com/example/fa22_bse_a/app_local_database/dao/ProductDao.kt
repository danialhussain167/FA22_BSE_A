package com.example.fa22_bse_a.app_local_database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.fa22_bse_a.login_migrated.model.LoginEntity
import com.example.fa22_bse_a.products.model.ProductEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    // select * from tableName
    @Query("select * from product_table")
    fun getAllProducts():Flow<List<ProductEntity>>

    @Query("select * from product_table where id=:id Limit 1")
    fun getProductEntity(id: String): ProductEntity

    @Insert
    fun insertProductEntity(productEntity: ProductEntity)

    @Insert
    fun insertAllProducts(productEntityList: List<ProductEntity>)

    @Query("delete from product_table where id=:id")
    fun deleteProductById(id: String)

    @Delete
    fun deleteProduct(productEntity: ProductEntity)

    @Update
    fun updateProduct(productEntity: ProductEntity)

}