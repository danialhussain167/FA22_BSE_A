package com.example.fa22_bse_a.app_local_database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.fa22_bse_a.chat.model.ChatModel
import kotlinx.coroutines.flow.Flow

@Dao
interface ChatDao {

    @Query("select * from chat_table")
    fun getAllChats(): Flow<List<ChatModel>>

    @Insert
    fun sendMessage(chatModel: ChatModel)


    @Query("select * from chat_table where id=:messageId LIMIT 1" )
    fun getMessageById(messageId: String): ChatModel?

    @Update
    fun updateMessage(chatModel: ChatModel)
}