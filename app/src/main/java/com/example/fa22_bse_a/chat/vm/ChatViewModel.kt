package com.example.fa22_bse_a.chat.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import com.example.fa22_bse_a.app_local_database.data_base.LocalDataBase
import com.example.fa22_bse_a.chat.model.ChatModel
import com.example.fa22_bse_a.chat.model.MessageStatus
import com.example.fa22_bse_a.chat.model.MessageType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ChatViewModel : ViewModel() {

    val refreshChatDataMLD: MutableLiveData<Unit> = MutableLiveData()
    val chatData: LiveData<List<ChatModel>> = refreshChatDataMLD.switchMap {
        LocalDataBase.getInstance().getChatDao().getAllChats().asLiveData()
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
                    message = message.value?:"",
                    time = System.currentTimeMillis().toString(),
                    messageStatus = MessageStatus.SENT,
                    messageType = MessageType.SENDER
                )
            )
            message.postValue("")
            refreshChatDataMLD.postValue(Unit)
        }

    }

}