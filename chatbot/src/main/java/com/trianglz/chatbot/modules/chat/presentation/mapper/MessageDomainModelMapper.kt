package com.trianglz.chatbot.modules.chat.presentation.mapper

import com.trianglz.chatbot.modules.chat.domain.models.ChatDomainModel
import com.trianglz.chatbot.modules.chat.presentation.models.ChatUIModel

fun ChatDomainModel.toUI(): ChatUIModel {

    return ChatUIModel(content = message, type = type)
}