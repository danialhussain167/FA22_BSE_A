package com.example.fa22_bse_a.user.adopter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fa22_bse_a.databinding.UserListItemBinding
import com.example.fa22_bse_a.login_migrated.model.LoginEntity
import com.example.fa22_bse_a.user.vm.UserViewModel

//Ui Layer / View
class UserAdopter(
    val userViewModel: UserViewModel
) : ListAdapter<LoginEntity, UserAdopter.UserViewHolder>(diffUtil) {

    inner class UserViewHolder(
        var binding: UserListItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding: UserListItemBinding =
            UserListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val data = getItem(position)
        if (userViewModel.loggedInPersonEmail == data.email) {
            holder.binding.loginModel = data.apply {
                name = "$name (You)"
            }
        } else {
            holder.binding.loginModel = data
        }

        holder.binding.root.setOnClickListener {
            userViewModel.triggerChatProcess(data.email)
        }

    }

}


val diffUtil = object : DiffUtil.ItemCallback<LoginEntity>() {
    override fun areItemsTheSame(oldItem: LoginEntity, newItem: LoginEntity): Boolean {
        return false
    }

    override fun areContentsTheSame(oldItem: LoginEntity, newItem: LoginEntity): Boolean {
        return false
    }

}