package com.example.fa22_bse_a.chat.vm

import androidx.lifecycle.ViewModel
import com.example.fa22_bse_a.chat.repository.ChatRepositoryImplementation
import com.example.fa22_bse_a.chat.repository.ChatRepositoryInterface


class ChatViewModel : ViewModel() {

    val chatRepo: ChatRepositoryInterface = ChatRepositoryImplementation()

}