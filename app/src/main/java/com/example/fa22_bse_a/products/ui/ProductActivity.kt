package com.example.fa22_bse_a.products.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fa22_bse_a.R
import com.example.fa22_bse_a.databinding.ProductListActivityBinding
import com.example.fa22_bse_a.products.adopter.ProductAdopter
import com.example.fa22_bse_a.products.model.Product
import com.example.fa22_bse_a.state_managment.SystemState

// UI layer
class ProductActivity : AppCompatActivity() {

    var binding: ProductListActivityBinding? = null
    var productAdopetr: ProductAdopter? = null
    val productsList: MutableList<Product> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.product_list_activity)

        productsList.addAll(
            arrayListOf(
                Product(
                    101.toString(),
                    imageIrl = "https://robbreport.com/wp-content/uploads/2024/08/temerario01.jpg?w=1200",
                    desc = "Lamborghini Temerario",
                    companyName = "Lamborghini",
                    price = 360000.0.toString(),
                    discount = 3.0.toString(),
//                quantity = 2
                ),
                Product(
                    102.toString(),
                    imageIrl = "https://robbreport.com/wp-content/uploads/2024/08/temerario01.jpg?w=1200",
                    desc = "Honda Civic",
                    companyName = "Honda",
                    price = 5000000.0.toString(),
                    discount = 2.0.toString(),
//                quantity = 1
                ),
                Product(
                    103.toString(),
                    imageIrl = "https://robbreport.com/wp-content/uploads/2024/08/temerario01.jpg?w=1200",
                    desc = "Mehran Boss",
                    companyName = "Suzuki",
                    price = 600000.0.toString(),
                    discount = 90.0.toString(),
//                quantity = 1
                ),
                Product(
                    104.toString(),
                    imageIrl = "https://robbreport.com/wp-content/uploads/2024/08/temerario01.jpg?w=1200",
                    desc = "Gujjer Tiyara",
                    companyName = "Gujjer Brother's",
                    price = 20.0.toString(),
                    discount = 99.99.toString(),
//                quantity = 50
                ),
                Product(
                    105.toString(),
                    imageIrl = "https://robbreport.com/wp-content/uploads/2024/08/temerario01.jpg?w=1200",
                    desc = "Cheema Time",
                    companyName = "Cheema Brother's",
                    price = 300000.0.toString(),
                    discount = 40.0.toString(),
//                quantity = 6
                ),
                Product(
                    106.toString(),
                    imageIrl = "https://robbreport.com/wp-content/uploads/2024/08/temerario01.jpg?w=1200",
                    desc = "Suzuki Khyber",
                    companyName = "Suzuki",
                    price = 700000.0.toString(),
                    discount = 70.0.toString(),
//                quantity = 50
                ),
            )
        )
        productAdopetr = ProductAdopter(deleteCallBack = { idToDelete ->
            Toast.makeText(
                this,
                "User tried to delete item with id${idToDelete}",
                Toast.LENGTH_SHORT
            ).show()
            val dataIndex = productsList.indexOf(productsList.find { it.id == idToDelete })
            productsList.removeAt(dataIndex)

            productAdopetr?.submitList(productsList)
            productAdopetr?.notifyDataSetChanged()

        }, editCallBack = {

            startActivity(Intent(this@ProductActivity, CraeteUpadteProdcut::class.java))
        })
//        productAdopetr?.setContext(this@ProductActivity)

        binding?.productRv?.adapter = productAdopetr
        binding?.productRv?.layoutManager = LinearLayoutManager(this)
        productAdopetr?.submitList(productsList)


        productAdopetr?.notifyDataSetChanged()


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

        Log.e(this@ProductActivity.javaClass.simpleName, "onCreate: productsList = $productsList")

    }

    override fun onResume() {
        super.onResume()
        if (SystemState.product != null) {
            if (productsList.filter { it.id == SystemState.product?.id }.size == 0) {
                productsList.add(SystemState.product!!)
            } else {
                val oldLocation =
                    productsList.indexOf(productsList.find { it.id == SystemState.product?.id })
                productsList[oldLocation] = SystemState.product!!
            }
            productAdopetr?.submitList(productsList)
            productAdopetr?.notifyDataSetChanged()
//                SystemState.product = null

        }
    }
}