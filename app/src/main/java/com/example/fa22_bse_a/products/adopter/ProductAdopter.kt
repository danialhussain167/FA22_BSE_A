package com.example.fa22_bse_a.products.adopter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fa22_bse_a.databinding.ProductListItemBinding
import com.example.fa22_bse_a.products.model.Product
import com.example.fa22_bse_a.state_managment.SystemState

//Ui Layer / View
class ProductAdopter(var deleteCallBack: (id:String) -> Unit, var editCallBack: (id:String) -> Unit) : ListAdapter<Product, ProductAdopter.ProductViewHolder>(diffUtil) {
//
//    var ctx: Context? = null
//
//    fun setContext(c: Context) {
//        this.ctx = c
//    }

    inner class ProductViewHolder(
        var prouctListItemBinding: ProductListItemBinding,
        var ctx: Context
    ) : RecyclerView.ViewHolder(prouctListItemBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding: ProductListItemBinding =
            ProductListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(prouctListItemBinding = binding, ctx = parent.context)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val data = getItem(position)
        holder.prouctListItemBinding.product = data

        holder.prouctListItemBinding.deleteBtn.setOnClickListener {
            deleteCallBack.invoke(data.id)
        }
        holder.prouctListItemBinding.editBtn.setOnClickListener {
            SystemState.product = data
            editCallBack.invoke(data.id)
        }


//        holder.prouctListItemBinding.root.setOnClickListener {
//            Toast.makeText(holder.ctx, "You clicked on row# ${position + 1}", Toast.LENGTH_SHORT)
//                .show()
//        }

    }


//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
//        val newProductRowBinding: ProductListItemBinding = ProductListItemBinding.inflate(
//            LayoutInflater.from(parent.context), parent,false)
//        return ProductViewHolder(productRowBinding = newProductRowBinding)
//    }
//
//    override fun onBindViewHolder(holder: ProductViewHolder, location: Int) {
//        val item = getItem(location)
//        holder.productRowBinding.product = item
////        holder.productRowBinding.price.setText(item.price.toString())
//    }
}


val diffUtil = object : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return false
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return false
    }

}