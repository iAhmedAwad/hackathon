package com.trianglz.chatbot.modules.chat.presentation.models

import com.example.chatbot_sdk.modules.chat.domain.models.enum.SenderType


data class ChatUIModel(
    val content: String?,
    val type: SenderType,
){
    val id: Int = System.identityHashCode(this)
}
