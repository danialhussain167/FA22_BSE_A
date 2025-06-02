package com.example.fa22_bse_a.chat.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fa22_bse_a.R
import com.example.fa22_bse_a.chat.adopter.ChatAdopter
import com.example.fa22_bse_a.chat.vm.ChatViewModel
import com.example.fa22_bse_a.databinding.ActivityChatBinding

class ChatActivity : AppCompatActivity() {

    var binding: ActivityChatBinding? = null
    var chatAdopter: ChatAdopter? = null
    val chatViewModel: ChatViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_chat)
        binding?.viewModel = chatViewModel
        binding?.lifecycleOwner = this

        if (intent.extras != null) {
            chatViewModel.chatRecipients =
                Pair(intent?.extras?.getString("from") ?: "", intent?.extras?.getString("to") ?: "")
        }
        chatAdopter = ChatAdopter(chatViewModel = chatViewModel)
        binding?.chatRv?.adapter = chatAdopter
        binding?.chatRv?.layoutManager = LinearLayoutManager(this)

        chatViewModel.filteredChat.observe(this) { chatList ->
            chatAdopter?.submitList(chatList)
            chatAdopter?.notifyDataSetChanged()
        }

    }
}


