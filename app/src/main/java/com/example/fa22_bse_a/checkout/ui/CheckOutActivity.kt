package com.example.fa22_bse_a.checkout.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fa22_bse_a.R
import com.example.fa22_bse_a.checkout.adopter.CartAdopter
import com.example.fa22_bse_a.checkout.vm.CheckOutViewModel
import com.example.fa22_bse_a.databinding.ActivityCheckOutBinding
import com.example.fa22_bse_a.products.view_model.CartViewModel

class CheckOutActivity : AppCompatActivity() {
    private var binding: ActivityCheckOutBinding? = null

    private val cartViewModel: CartViewModel by viewModels()
    private val checkOutViewModel: CheckOutViewModel by viewModels()
    private var cartAdopter: CartAdopter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_check_out)
        binding?.checkOutViewModel = checkOutViewModel
        binding?.cartViewModel = cartViewModel
        binding?.lifecycleOwner = this

        cartAdopter = CartAdopter(cartViewModel = cartViewModel)
        binding?.cartItemsRv?.adapter = cartAdopter
        binding?.cartItemsRv?.layoutManager = LinearLayoutManager(this)

        checkOutViewModel.cardNumberMLD.observe(this) {

        }

        cartViewModel.allCartItems.observe(this) { allCartItems ->
            cartAdopter?.submitList(allCartItems)
            cartAdopter?.notifyDataSetChanged()
        }
    }
}