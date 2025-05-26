package com.example.fa22_bse_a.chat.model

import androidx.room.Entity


@Entity(tableName = "chat_table", primaryKeys = ["id"])
data class ChatModel(
    val id: String,
    val message: String,
    val time: String,
    var messageStatus: MessageStatus? = null,
    val messageType: MessageType
)

enum class MessageStatus {
    SENT,
    DELIVERED,
    SEEN,
    DELETED,
    UPDATED
}

enum class MessageType {
    SENDER,
    RECEIVER
}