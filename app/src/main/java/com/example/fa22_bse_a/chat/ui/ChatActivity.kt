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
        chatAdopter = ChatAdopter()
        binding?.chatRv?.adapter = chatAdopter
        binding?.chatRv?.layoutManager = LinearLayoutManager(this)
//        val messagesList = getChatData()


        chatViewModel.chatData.observe(this) { chatList ->
            chatAdopter?.submitList(chatList)
            chatAdopter?.notifyDataSetChanged()
        }

//        lifecycleScope.launch(Dispatchers.IO) {
//            delay(10000)
//            messagesList[messagesList.size - 1] =
//                messagesList.getOrNull(messagesList.size - 1)?.apply {
//                    messageStatus = MessageStatus.SEEN
//                }
//            withContext(Dispatchers.Main) {
//                chatAdopter?.submitList(messagesList)
//                chatAdopter?.notifyItemChanged(messagesList.size - 1)
//            }
//        }

    }


//    fun getChatData() = mutableListOf<ChatModel?>(
//        ChatModel(
//            message = "Hi, How are you?",
//            time = "2:13 PM",
//            messageStatus = MessageStatus.SEEN,
//            messageType = MessageType.SENDER
//        ),
//        ChatModel(
//            message = "I am fine, What about you?",
//            time = "2:14 PM",
//            messageType = MessageType.RECEIVER
//        ),
//        ChatModel(
//            message = "What's going on?",
//            time = "3:00 PM",
//            messageStatus = MessageStatus.SEEN,
//            messageType = MessageType.SENDER
//        ),
//        ChatModel(
//            message = "Doing some assignments?",
//            time = "3:01 PM",
//            messageType = MessageType.RECEIVER
//        ),
//        ChatModel(
//            message = "Best of luck?",
//            time = "3:02 PM",
//            messageStatus = MessageStatus.SENT,
//            messageType = MessageType.SENDER
//        ),
//    )
}


