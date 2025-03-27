package com.example.fa22_bse_a.products.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fa22_bse_a.R
import com.example.fa22_bse_a.databinding.ProductListActivityBinding
import com.example.fa22_bse_a.products.adopter.ProductAdopter
import com.example.fa22_bse_a.products.model.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductActivity : AppCompatActivity() {

    var binding: ProductListActivityBinding? = null
    var productAdopetr: ProductAdopter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.product_list_activity)

        val productsList: MutableList<Product> = arrayListOf(
            Product(
                imageIrl = "https://robbreport.com/wp-content/uploads/2024/08/temerario01.jpg?w=1200",
                desc = "Lamborghini Temerario",
                companyName = "Lamborghini",
                price = 360000.0,
                discount = 3.0,
                quantity = 2
            ),
            Product(
                imageIrl = "https://robbreport.com/wp-content/uploads/2024/08/temerario01.jpg?w=1200",
                desc = "Honda Civic",
                companyName = "Honda",
                price = 5000000.0,
                discount = 2.0,
                quantity = 1
            ),
            Product(
                imageIrl = "https://robbreport.com/wp-content/uploads/2024/08/temerario01.jpg?w=1200",
                desc = "Mehran Boss",
                companyName = "Suzuki",
                price = 600000.0,
                discount = 90.0,
                quantity = 1
            ),
            Product(
                imageIrl = "https://robbreport.com/wp-content/uploads/2024/08/temerario01.jpg?w=1200",
                desc = "Gujjer Tiyara",
                companyName = "Gujjer Brother's",
                price = 20.0,
                discount = 99.99,
                quantity = 50
            ),
            Product(
                imageIrl = "https://robbreport.com/wp-content/uploads/2024/08/temerario01.jpg?w=1200",
                desc = "Cheema Time",
                companyName = "Cheema Brother's",
                price = 300000.0,
                discount = 40.0,
                quantity = 6
            ),
            Product(
                imageIrl = "https://robbreport.com/wp-content/uploads/2024/08/temerario01.jpg?w=1200",
                desc = "Suzuki Khyber",
                companyName = "Suzuki",
                price = 700000.0,
                discount = 70.0,
                quantity = 50
            ),
        )
        productAdopetr = ProductAdopter()

        binding?.productRv?.adapter = productAdopetr
        binding?.productRv?.layoutManager = LinearLayoutManager(this)
        productAdopetr?.submitList(productsList)


        productAdopetr?.notifyDataSetChanged()



        lifecycleScope.launch(Dispatchers.IO) {
            delay(5000)
            productsList.get(0).price = 40.0
            withContext(Dispatchers.Main) {
                productAdopetr?.submitList(productsList)
                productAdopetr?.notifyItemChanged(0)
            }
        }

        Log.e(this@ProductActivity.javaClass.simpleName, "onCreate: productsList = $productsList")

    }
}