package com.trianglz.chatbot.modules.chat.data.models

import com.example.chatbot_sdk.modules.chat.domain.models.enum.SenderType


data class ChatDataModel(
    val id: Int,
    val message: String?,
    val type: SenderType,
)
