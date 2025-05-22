package com.example.fa22_bse_a.checkout.adopter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fa22_bse_a.databinding.CartListItemBinding
import com.example.fa22_bse_a.products.model.CartItem
import com.example.fa22_bse_a.products.view_model.CartViewModel

//Ui Layer / View
class CartAdopter(val cartViewModel: CartViewModel) : ListAdapter<CartItem, CartAdopter.CartViewHolder>(diffUtil) {


    inner class CartViewHolder(
        var binding: CartListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding: CartListItemBinding =
            CartListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val data = getItem(position)
        holder.binding.cartViewModel = cartViewModel
        holder.binding.cartItem = data

        (data.quantity.toDouble() * (data.price?.toDouble() ?: 0.0)).let { totalPrice ->
            (totalPrice - ((totalPrice / 100.0) * (data.discount?.toDouble()?:0.0))).let { discountedPrice ->
                holder.binding.totalPrice.setText("PKR ${discountedPrice}")
            }
        }
    }
}

val diffUtil = object : DiffUtil.ItemCallback<CartItem>() {
    override fun areItemsTheSame(oldItem: CartItem, newItem: CartItem): Boolean {
        return false
    }

    override fun areContentsTheSame(oldItem: CartItem, newItem: CartItem): Boolean {
        return false
    }

}