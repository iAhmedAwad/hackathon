package com.example.chatbot_sdk.modules.chat.domain.models

import com.example.chatbot_sdk.modules.chat.domain.models.enum.SenderType


data class MessageDomainModel(
    val id: String,
    val messageContent: String?,
    val type: SenderType,
)
