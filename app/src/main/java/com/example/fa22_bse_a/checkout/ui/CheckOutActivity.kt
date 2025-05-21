package com.example.fa22_bse_a.checkout.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.fa22_bse_a.R
import com.example.fa22_bse_a.checkout.vm.CheckOutViewModel
import com.example.fa22_bse_a.databinding.ActivityCheckOutBinding
import com.example.fa22_bse_a.products.view_model.CartViewModel

class CheckOutActivity : AppCompatActivity() {
    var binding: ActivityCheckOutBinding? = null

    val cartViewModel: CartViewModel by viewModels()
    val checkOutViewModel: CheckOutViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_check_out)
        binding?.checkOutViewModel = checkOutViewModel
        binding?.lifecycleOwner = this
        checkOutViewModel.cardNumberMLD.observe(this) {

        }
    }
}