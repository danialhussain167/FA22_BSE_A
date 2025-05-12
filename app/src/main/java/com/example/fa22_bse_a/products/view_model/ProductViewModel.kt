package com.example.fa22_bse_a.products.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.fa22_bse_a.app_local_database.data_base.LocalDataBase
import com.example.fa22_bse_a.products.model.Product
import com.example.fa22_bse_a.products.model.ProductEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {

    val productListDB: LiveData<List<ProductEntity>> = LocalDataBase.getInstance().getProductDao().getAllProducts().asLiveData()

    fun deleteProduct(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            Log.e("ProductViewModel", "deleteProduct: id = $id", )
            LocalDataBase.getInstance().getProductDao().deleteProductById(id = id)
        }
    }














//    val productsList: MutableList<ProductEntity> = arrayListOf(
//        ProductEntity(
//            101.toString(),
//            imageIrl = "https://robbreport.com/wp-content/uploads/2024/08/temerario01.jpg?w=1200",
//            desc = "Lamborghini Temerario",
//            companyName = "Lamborghini",
//            price = 360000.0.toString(),
//            discount = 3.0.toString(),
////                quantity = 2
//        ),
//        ProductEntity(
//            102.toString(),
//            imageIrl = "https://robbreport.com/wp-content/uploads/2024/08/temerario01.jpg?w=1200",
//            desc = "Honda Civic",
//            companyName = "Honda",
//            price = 5000000.0.toString(),
//            discount = 2.0.toString(),
////                quantity = 1
//        ),
//        ProductEntity(
//            103.toString(),
//            imageIrl = "https://robbreport.com/wp-content/uploads/2024/08/temerario01.jpg?w=1200",
//            desc = "Mehran Boss",
//            companyName = "Suzuki",
//            price = 600000.0.toString(),
//            discount = 90.0.toString(),
////                quantity = 1
//        ),
//        ProductEntity(
//            104.toString(),
//            imageIrl = "https://robbreport.com/wp-content/uploads/2024/08/temerario01.jpg?w=1200",
//            desc = "Gujjer Tiyara",
//            companyName = "Gujjer Brother's",
//            price = 20.0.toString(),
//            discount = 99.99.toString(),
////                quantity = 50
//        ),
//        ProductEntity(
//            105.toString(),
//            imageIrl = "https://robbreport.com/wp-content/uploads/2024/08/temerario01.jpg?w=1200",
//            desc = "Cheema Time",
//            companyName = "Cheema Brother's",
//            price = 300000.0.toString(),
//            discount = 40.0.toString(),
////                quantity = 6
//        ),
//        ProductEntity(
//            106.toString(),
//            imageIrl = "https://robbreport.com/wp-content/uploads/2024/08/temerario01.jpg?w=1200",
//            desc = "Suzuki Khyber",
//            companyName = "Suzuki",
//            price = 700000.0.toString(),
//            discount = 70.0.toString(),
////                quantity = 50
//        )
//    )


}