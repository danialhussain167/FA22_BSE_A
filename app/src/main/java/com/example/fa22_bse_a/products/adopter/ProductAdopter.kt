package com.example.fa22_bse_a.products.adopter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fa22_bse_a.databinding.ProductListItemBinding
import com.example.fa22_bse_a.products.model.Product

class ProductAdopter: ListAdapter<Product, ProductAdopter.ProductViewHolder>(diffUtil) {


    inner class ProductViewHolder(var productRowBinding: ProductListItemBinding): RecyclerView.ViewHolder(productRowBinding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val newProductRowBinding: ProductListItemBinding = ProductListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent,false)
        return ProductViewHolder(productRowBinding = newProductRowBinding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, location: Int) {
        val item = getItem(location)
        holder.productRowBinding.product = item
//        holder.productRowBinding.price.setText(item.price.toString())
    }
}


val diffUtil =  object: DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return false
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return false
    }

}