package com.example.chatbot_sdk.modules.chat.presentation.mapper

import com.example.chatbot_sdk.modules.chat.domain.models.MessageDomainModel
import com.example.chatbot_sdk.modules.chat.presentation.models.MessageUIModel

fun MessageDomainModel.toUI(): MessageUIModel {

    return MessageUIModel(id = id, content = messageContent, type = type)
}