package com.example.fa22_bse_a.chat.adopter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fa22_bse_a.chat.model.ChatModel
import com.example.fa22_bse_a.chat.model.MessageType
import com.example.fa22_bse_a.databinding.ReceiverRowItemBinding
import com.example.fa22_bse_a.databinding.SenderRowItemBinding

class ChatAdopter :ListAdapter<ChatModel, RecyclerView.ViewHolder>(diffCheker) {


    inner class SenderViewHolder(val binding: SenderRowItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    inner class ReceiverViewHolder(val binding: ReceiverRowItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun getItemViewType(position: Int): Int {
        val data = getItem(position)
        return if(data.messageType == MessageType.SENDER){
            1 // sender
        } else {
            2 // receiver
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == 1) { // sender
            val binding:SenderRowItemBinding =  SenderRowItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)

            return SenderViewHolder(binding = binding)
        } else { // receiver
            val binding:ReceiverRowItemBinding =  ReceiverRowItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return ReceiverViewHolder(binding = binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = getItem(position)

        if(data.messageType == MessageType.SENDER) {
            (holder as SenderViewHolder).binding.chatModel = data
        } else {
            (holder as ReceiverViewHolder).binding.chatModel = data
        }
    }


}

val diffCheker = object : ItemCallback<ChatModel>() {
    override fun areItemsTheSame(oldItem: ChatModel, newItem: ChatModel): Boolean {
        return false
    }

    override fun areContentsTheSame(oldItem: ChatModel, newItem: ChatModel): Boolean {
        return false
    }

}