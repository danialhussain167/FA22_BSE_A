package com.example.fa22_bse_a.products.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.example.fa22_bse_a.app_local_database.data_base.LocalDataBase
import com.example.fa22_bse_a.products.model.Product
import com.example.fa22_bse_a.products.model.ProductEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CreateProductViewModel: ViewModel() {

    var product: ProductEntity = ProductEntity()

    val onProductCreateTriggerStateMLD: MutableLiveData<Boolean> = MutableLiveData()


    val productScreenState: MutableLiveData<ScreenState> = MutableLiveData()


    fun onCreateOrUpdateProduct(){
        viewModelScope.launch(Dispatchers.IO) {
            if(productScreenState.value == ScreenState.Create) {
                LocalDataBase.getInstance().getProductDao().insertProductEntity(productEntity = product)
            } else {
                LocalDataBase.getInstance().getProductDao().updateProduct(product)
            }
        }
        onProductCreateTriggerStateMLD.value = true
    }

    fun getProductForUpdate(productId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            product = LocalDataBase.getInstance().getProductDao().getProductEntity(productId)
        }
    }
}

enum class ScreenState {
    Create,
    Update
}