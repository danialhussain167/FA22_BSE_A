package com.example.fa22_bse_a.products.view_model

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.map
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import com.example.fa22_bse_a.FA22BSEApplication
import com.example.fa22_bse_a.app_local_database.data_base.LocalDataBase
import com.example.fa22_bse_a.products.model.CartItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CartViewModel : ViewModel() {


    val triggerRefreshCartItems: MutableLiveData<Unit> = MutableLiveData()

    val allCartItems: LiveData<List<CartItem>> = triggerRefreshCartItems.switchMap {
        LocalDataBase.getInstance().getCartDao().getAllCartItems().asLiveData()
    }

    init {
        triggerRefreshCartItems.value = Unit
    }

    fun addProductToCart(productId: String) {
        Toast.makeText(
            FA22BSEApplication.getAppContext(),
            "Process to add Item with Id = ${productId} is initiated",
            Toast.LENGTH_SHORT
        ).show()
        viewModelScope.launch(Dispatchers.IO) {

            val productItem =
                LocalDataBase.getInstance().getProductDao().getProductEntity(id = productId)
            val cartItem: CartItem = CartItem(
                id = productItem.id,
                imageUrl = productItem.imageIrl,
                desc = productItem.desc,
                companyName = productItem.companyName,
                price = productItem.price,
                discount = productItem.discount,
                quantity = 1
            )
            LocalDataBase.getInstance().getCartDao().insertCartItem(cartItem)
            withContext(Dispatchers.Main) {
                Toast.makeText(
                    FA22BSEApplication.getAppContext(),
                    "Product with Id = ${productId} is added to Cart",
                    Toast.LENGTH_SHORT
                ).show()
                triggerRefreshCartItems.value = Unit
            }

        }

//        val ListOfA = arrayListOf(
//            A(name = "Ali", age = 30),
//            A(name = "CR", age = 200000000),
//            A(name = "kaif", age = -20)
//        )
//
//        val namesList = ListOfA.map { B(name = it.name) }

    }

    fun getItemQuantityInCart(productId: String): Int {
        return allCartItems.value?.filter { it.id == productId }?.getOrNull(0)?.quantity ?: 0
    }

    fun decrementCartItemQuantity(cartItemId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val cartItem = LocalDataBase.getInstance().getCartDao().getCartItemById(id = cartItemId)
            cartItem?.let {
                if (cartItem.quantity == 1) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            FA22BSEApplication.getAppContext(),
                            "Deleting Cart Item with Id = $cartItemId",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    LocalDataBase.getInstance().getCartDao().deleteCartItem(cartItem = cartItem)
                } else {
                    cartItem.quantity -= 1
                    LocalDataBase.getInstance().getCartDao().updateCartItem(cartItem)
                }
                withContext(Dispatchers.Main) {
                    triggerRefreshCartItems.value = Unit

                }
            }


        }
    }

    fun incrementCartItemQuantity(cartItemId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val cartItem = LocalDataBase.getInstance().getCartDao().getCartItemById(id = cartItemId)
            cartItem?.let {
                cartItem.quantity += 1
                LocalDataBase.getInstance().getCartDao().updateCartItem(cartItem)
                withContext(Dispatchers.Main) {
                    triggerRefreshCartItems.value = Unit

                }
            }
        }
    }


    fun deleteCartItem(cartItemId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val cartItem = LocalDataBase.getInstance().getCartDao().getCartItemById(cartItemId)

            cartItem?.let {
                LocalDataBase.getInstance().getCartDao().deleteCartItem(cartItem)
            }
            triggerRefreshCartItems.postValue(Unit)
        }
    }

    val totalBillLD: LiveData<String> = allCartItems.map { allCartItems ->
        var totalBill: Double = 0.0
        allCartItems.forEach { singleCartItem ->
            (singleCartItem.quantity.toDouble() * (singleCartItem.price?.toDouble() ?: 0.0)).let { singleItemTotalPrice ->
                (singleItemTotalPrice - ((singleItemTotalPrice / 100.0) * (singleCartItem.discount?.toDouble()?:0.0))).let { signleItemDiscountedPrice ->
                   totalBill+=signleItemDiscountedPrice
                }
            }
        }
        "PKR ${totalBill}"
    }

}

//data class A(
//    val name: String = "",
//    val age: Int
//)
//
//data class B(
//    val name: String
//)