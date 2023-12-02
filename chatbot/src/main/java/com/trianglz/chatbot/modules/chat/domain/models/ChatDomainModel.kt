package com.trianglz.chatbot.modules.chat.domain.models

import com.example.chatbot_sdk.modules.chat.domain.models.enum.SenderType


data class ChatDomainModel(
    val id: Int,
    val message: String?,
    val type: SenderType,
)
