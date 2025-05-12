package com.example.fa22_bse_a.products.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fa22_bse_a.products.model.Product
import com.example.fa22_bse_a.products.model.ProductEntity

class CreateProductViewModel: ViewModel() {

    var product: ProductEntity = ProductEntity()

    val onProductCreateTriggerStateMLD: MutableLiveData<Boolean> = MutableLiveData()




    fun onCreateProduct(){
        onProductCreateTriggerStateMLD.value = true
    }
}