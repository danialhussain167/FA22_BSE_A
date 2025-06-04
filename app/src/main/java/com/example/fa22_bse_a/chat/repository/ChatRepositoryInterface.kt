package com.example.fa22_bse_a.chat.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.fa22_bse_a.chat.model.ChatModel
import kotlinx.coroutines.flow.Flow

interface ChatRepositoryInterface {

    var chatRecipients: Pair<String, String>
    val refreshChatDataMLD: MutableLiveData<Unit>
    val chatData: LiveData<List<ChatModel>>
    val filteredChat: LiveData<List<ChatModel>>
    var message: MutableLiveData<String>

    fun getAllChats(): Flow<List<ChatModel>>

    fun sendMessage()

    fun setMessageAsSeen(messageId: String)

    fun setMessageAsDelivered(messageId: String)
}