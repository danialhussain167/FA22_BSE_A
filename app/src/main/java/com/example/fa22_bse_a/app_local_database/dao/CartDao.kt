package com.example.fa22_bse_a.app_local_database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.fa22_bse_a.login_migrated.model.LoginEntity
import com.example.fa22_bse_a.products.model.CartItem
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {

    // select * from tableName
    @Query("select * from cart_table")
    fun getAllCartItems(): Flow<List<CartItem>>

    @Query("select * from cart_table where id=:id Limit 1")
    fun getCartItemById(id: String): CartItem?

    @Insert
    fun insertCartItem(cartItem: CartItem)

    @Insert
    fun insertAllCartItems(cartItemList: List<CartItem>)

    @Delete
    fun deleteCartItem(cartItem: CartItem)

    @Query("Delete from cart_table where id=:cartItemId")
    fun deleteCartItemById(cartItemId: String)

    @Update
    fun updateCartItem(cartItem: CartItem)
}