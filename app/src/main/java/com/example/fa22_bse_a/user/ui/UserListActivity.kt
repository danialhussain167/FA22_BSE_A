package com.example.fa22_bse_a.user.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fa22_bse_a.R
import com.example.fa22_bse_a.chat.model.MessageStatus
import com.example.fa22_bse_a.chat.ui.ChatActivity
import com.example.fa22_bse_a.chat.vm.ChatViewModel
import com.example.fa22_bse_a.databinding.ActivityUserListBinding
import com.example.fa22_bse_a.user.adopter.UserAdopter
import com.example.fa22_bse_a.user.vm.UserViewModel

class UserListActivity : AppCompatActivity() {

    var binding: ActivityUserListBinding? = null
    val userViewModel: UserViewModel by viewModels()
    var userAdopter: UserAdopter? = null

    val chatViewModel: ChatViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_list)
        binding?.lifecycleOwner = this
        if (intent.extras != null) {
            userViewModel.loggedInPersonEmail = intent?.extras?.getString("email") ?: ""
        }

        userAdopter = UserAdopter(userViewModel = userViewModel)
        binding?.userRv?.adapter = userAdopter
        binding?.userRv?.layoutManager = LinearLayoutManager(this)
        userViewModel.loginList.observe(this) { allUsers ->
            userAdopter?.submitList(allUsers)
            userAdopter?.notifyDataSetChanged()
        }

        userViewModel.initiateChatMLD.observe(this) {
            startActivity(
                Intent(this, ChatActivity::class.java).putExtra("to", it)
                    .putExtra("from", userViewModel.loggedInPersonEmail)
            )
        }

        chatViewModel.chatRepo.chatData.observe(this) { allChats ->
            allChats.filter { it.to == userViewModel.loggedInPersonEmail && it.messageStatus == MessageStatus.SENT }
                .forEach { messageToSetDelivered ->
                    chatViewModel.chatRepo.setMessageAsDelivered(messageToSetDelivered.id)
                }
        }
    }
}