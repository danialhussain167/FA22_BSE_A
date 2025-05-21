package com.example.fa22_bse_a.products.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fa22_bse_a.R
import com.example.fa22_bse_a.checkout.ui.CheckOutActivity
import com.example.fa22_bse_a.databinding.ProductListActivityBinding
import com.example.fa22_bse_a.products.adopter.ProductAdopter
import com.example.fa22_bse_a.products.view_model.CartViewModel
import com.example.fa22_bse_a.products.view_model.ProductViewModel
import com.example.fa22_bse_a.state_managment.SystemState

// UI layer
class ProductActivity : AppCompatActivity() {

    var binding: ProductListActivityBinding? = null
    var productAdopetr: ProductAdopter? = null
    val productViewModel: ProductViewModel by viewModels()
    val cartViewModel: CartViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.product_list_activity)

        binding?.cartViewModel = cartViewModel

        binding?.lifecycleOwner = this
        productAdopetr =
            ProductAdopter(productViewModel = productViewModel, cartViewModel = cartViewModel)
        binding?.productRv?.adapter = productAdopetr
        binding?.productRv?.layoutManager = LinearLayoutManager(this)
        productViewModel.productListDB.observe(this) { productListFromDB ->
            cartViewModel.triggerRefreshCartItems.value = Unit
            productAdopetr?.submitList(productListFromDB)
            productAdopetr?.notifyDataSetChanged()
        }

        cartViewModel.allCartItems.observe(this) { cartItemsList ->
            Log.e("ProductActivity", "cartItemsList = $cartItemsList")
            productAdopetr?.notifyDataSetChanged()
        }

        productViewModel.productUpdateTriggerStateMLD.observe(this) { productId ->
            startActivity(
                Intent(
                    this@ProductActivity,
                    CraeteUpadteProdcut::class.java
                ).putExtra("ProductId", productId)
            )
        }

        binding?.cartButton?.setOnClickListener {
            startActivity(Intent(this, CheckOutActivity::class.java))
        }




//            deleteCallBack = { idToDelete ->
//            Toast.makeText(
//                this,
//                "User tried to delete item with id${idToDelete}",
//                Toast.LENGTH_SHORT
//            ).show()
//            val dataIndex =
//                productViewModel.productsList.indexOf(productViewModel.productsList.find { it.id == idToDelete })
//            productViewModel.productsList.removeAt(dataIndex)
//
//            productAdopetr?.submitList(productViewModel.productsList)
//            productAdopetr?.notifyDataSetChanged()

//        }, editCallBack = {

//            startActivity(Intent(this@ProductActivity, CraeteUpadteProdcut::class.java))
//        }
//        )
//        productAdopetr?.setContext(this@ProductActivity)


//        productAdopetr?.submitList(productViewModel.productsList)
//
//
//        productAdopetr?.notifyDataSetChanged()


        binding?.addBtn?.setOnClickListener {
            SystemState.product = null
            startActivity(Intent(this@ProductActivity, CraeteUpadteProdcut::class.java))
        }

//
//        lifecycleScope.launch(Dispatchers.IO) {
//            delay(5000)
//            productsList.get(0).price = 40.0
//            withContext(Dispatchers.Main) {
//                productAdopetr?.submitList(productsList)
//                productAdopetr?.notifyItemChanged(0)
//            }
//        }

//        Log.e(
//            this@ProductActivity.javaClass.simpleName,
//            "onCreate: productsList = ${productViewModel.productsList}"
//        )

    }

    override fun onResume() {
        super.onResume()

//        if (SystemState.product != null) {
//            if (productViewModel.productsList.filter { it.id == SystemState.product?.id }.size == 0) {
//                productViewModel.productsList.add(SystemState.product!!)
//            } else {
//                val oldLocation =
//                    productViewModel.productsList.indexOf(productViewModel.productsList.find { it.id == SystemState.product?.id })
//                productViewModel.productsList[oldLocation] = SystemState.product!!
//            }
//            productAdopetr?.submitList(productViewModel.productsList)
//            productAdopetr?.notifyDataSetChanged()
////                SystemState.product = null
//
//        }
    }

}