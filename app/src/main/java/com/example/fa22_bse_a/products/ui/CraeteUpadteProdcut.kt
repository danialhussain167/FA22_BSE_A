package com.example.fa22_bse_a.products.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.fa22_bse_a.R
import com.example.fa22_bse_a.app_local_database.data_base.LocalDataBase
import com.example.fa22_bse_a.databinding.ActivityCraeteUpadteProdcutBinding
import com.example.fa22_bse_a.products.model.Product
import com.example.fa22_bse_a.products.model.ProductEntity
import com.example.fa22_bse_a.products.view_model.CreateProductViewModel
import com.example.fa22_bse_a.products.view_model.ScreenState
import com.example.fa22_bse_a.state_managment.SystemState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CraeteUpadteProdcut : AppCompatActivity() {


    var binding: ActivityCraeteUpadteProdcutBinding? = null

    val createProductViewModel: CreateProductViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_craete_upadte_prodcut)
        binding?.createProductViewModel = createProductViewModel
        var productId: String? = null
        if(intent?.extras != null) {
            productId = intent?.extras?.getString("ProductId")
        }

        if(productId !=  null) {
            createProductViewModel.productScreenState.value = ScreenState.Update
            createProductViewModel.getProductForUpdate(productId)
            binding?.btnSubmit?.setText("Update")
        } else {
            createProductViewModel.productScreenState.value = ScreenState.Create
        }

        createProductViewModel.onProductCreateTriggerStateMLD.observe(this) {
            Log.e("TAG", "onCreate: createProductViewModel.onProductCreateTriggerStateMLD ${it}", )
            if(it == true) {
                // Store Product in DB
//                createProductViewModel.product
//                lifecycleScope.launch(Dispatchers.IO) {
//                    LocalDataBase.getInstance().getProductDao().insertProductEntity(productEntity = createProductViewModel.product)
//                }
                finish()
            }
        }



//
//        if(SystemState.product != null) {
//            createProductViewModel.product = SystemState.product!!
//            binding?.etId?.isEnabled = false
//            binding?.btnSubmit?.setText("Update Product")
//        }



//        binding?.product = createProductViewModel.product

//        binding?.btnSubmit?.setOnClickListener {
//            SystemState.product = product
//            Toast.makeText(this, "Product Created", Toast.LENGTH_SHORT).show()
//            finish()
//        }

    }

    override fun onResume() {
        super.onResume()

    }
}