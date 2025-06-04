package com.example.fa22_bse_a.chat.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.map
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import com.example.fa22_bse_a.app_local_database.data_base.LocalDataBase
import com.example.fa22_bse_a.chat.model.ChatModel
import com.example.fa22_bse_a.chat.model.MessageStatus
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
// Clean Architecture


class ChatRepositoryImplementation: ChatRepositoryInterface {

    override var chatRecipients: Pair<String, String> = Pair("", "") // from (jo ,login hua hua he) , to (jiss ki chat open hoi he)

    override val refreshChatDataMLD: MutableLiveData<Unit> = MutableLiveData()

    override val chatData: LiveData<List<ChatModel>> = refreshChatDataMLD.switchMap {
        getAllChats().asLiveData()
    }

    override val filteredChat: LiveData<List<ChatModel>> = chatData.map { allChatRecords ->
        allChatRecords.filter { (chatRecipients.first == it.from && chatRecipients.second == it.to) || (chatRecipients.first == it.to && chatRecipients.second == it.from) }
    }

    override var message: MutableLiveData<String> = MutableLiveData("")


    override fun getAllChats(): Flow<List<ChatModel>> {
        return LocalDataBase.getInstance().getChatDao().getAllChats()
    }


    init {
        refreshChatDataMLD.value = Unit
    }


    override fun sendMessage() {
        CoroutineScope(Dispatchers.IO).launch {
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

    override fun setMessageAsSeen(messageId: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val actualMessage =
                LocalDataBase.getInstance().getChatDao().getMessageById(messageId = messageId)
            actualMessage?.let {
                LocalDataBase.getInstance().getChatDao().updateMessage(actualMessage.apply {
                    messageStatus = MessageStatus.SEEN
                })
            }
        }
    }

    override fun setMessageAsDelivered(messageId: String) {
        CoroutineScope(Dispatchers.IO).launch {
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