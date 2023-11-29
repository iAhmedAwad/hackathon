package com.example.chatbot_sdk.modules.chat.presentation.models

import com.example.chatbot_sdk.modules.chat.domain.models.enum.SenderType


data class MessageUIModel(
    val id: String,
    val content: String?,
    val type: SenderType,
)
