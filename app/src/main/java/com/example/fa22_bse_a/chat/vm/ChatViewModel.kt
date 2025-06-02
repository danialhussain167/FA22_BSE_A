package com.example.fa22_bse_a.chat.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.map
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import com.example.fa22_bse_a.app_local_database.data_base.LocalDataBase
import com.example.fa22_bse_a.chat.model.ChatModel
import com.example.fa22_bse_a.chat.model.MessageStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ChatViewModel : ViewModel() {

    var chatRecipients: Pair<String, String> = Pair("", "") // from (jo ,login hua hua he) , to (jiss ki chat open hoi he)
    val refreshChatDataMLD: MutableLiveData<Unit> = MutableLiveData()
    val chatData: LiveData<List<ChatModel>> = refreshChatDataMLD.switchMap {
        LocalDataBase.getInstance().getChatDao().getAllChats().asLiveData()
    }

    val filteredChat: LiveData<List<ChatModel>> = chatData.map { allChatRecords ->
        allChatRecords.filter { (chatRecipients.first == it.from && chatRecipients.second == it.to) || (chatRecipients.first == it.to && chatRecipients.second == it.from) }
    }

    var message: MutableLiveData<String> = MutableLiveData("")


    init {
        refreshChatDataMLD.value = Unit
    }

    fun sendMessage() {
        viewModelScope.launch(Dispatchers.IO) {
            LocalDataBase.getInstance().getChatDao().sendMessage(
                ChatModel(
                    id = System.currentTimeMillis().toString(),
                    message = message.value ?: "",
                    time = System.currentTimeMillis().toString(),
                    messageStatus = MessageStatus.SENT,
                    to = chatRecipients.second,
                    from = chatRecipients.first
                )
            )
            message.postValue("")
            refreshChatDataMLD.postValue(Unit)
        }

    }


    fun setMessageAsSeen(messageId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val actualMessage =
                LocalDataBase.getInstance().getChatDao().getMessageById(messageId = messageId)
            actualMessage?.let {
                LocalDataBase.getInstance().getChatDao().updateMessage(actualMessage.apply {
                    messageStatus = MessageStatus.SEEN
                })
            }
        }
    }

    fun setMessageAsDelivered(messageId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val actualMessage =
                LocalDataBase.getInstance().getChatDao().getMessageById(messageId = messageId)
            actualMessage?.let {
                LocalDataBase.getInstance().getChatDao().updateMessage(actualMessage.apply {
                    messageStatus = MessageStatus.DELIVERED
                })
            }

        }
    }



}