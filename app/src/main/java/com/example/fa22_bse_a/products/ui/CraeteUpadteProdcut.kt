package com.example.fa22_bse_a.products.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.fa22_bse_a.R
import com.example.fa22_bse_a.databinding.ActivityCraeteUpadteProdcutBinding
import com.example.fa22_bse_a.products.model.Product
import com.example.fa22_bse_a.state_managment.SystemState

class CraeteUpadteProdcut : AppCompatActivity() {


    var binding: ActivityCraeteUpadteProdcutBinding? = null

    var product: Product = Product()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_craete_upadte_prodcut)
        if(SystemState.product != null) {
            this@CraeteUpadteProdcut.product = SystemState.product!!
            binding?.etId?.isEnabled = false

            binding?.btnSubmit?.setText("Update Product")
        }
        binding?.product = product

        binding?.btnSubmit?.setOnClickListener {
            SystemState.product = product
            Toast.makeText(this, "Product Created", Toast.LENGTH_SHORT).show()
            finish()
        }

    }

    override fun onResume() {
        super.onResume()

    }
}