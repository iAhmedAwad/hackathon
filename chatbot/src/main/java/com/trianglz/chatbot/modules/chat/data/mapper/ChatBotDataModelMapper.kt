package com.trianglz.chatbot.modules.chat.data.mapper

import com.example.chatbot_sdk.modules.chat.domain.models.enum.SenderType
import com.trianglz.chatbot.modules.chat.data.models.ChatDataModel
import com.trianglz.chatbot.modules.chat.data.remote.retrofit.models.response.ChatBotResponseModel
import com.trianglz.chatbot.modules.chat.domain.models.ChatDomainModel

/**
 * @author Awad for TrianglZ
 * Created 12/2/2023 at 12:12 PM
 */

fun ChatBotResponseModel.toData(): ChatDataModel {
    return ChatDataModel(
        id = System.identityHashCode(this),
        message = response.orEmpty(),
        type = SenderType.OTHER
    )
}

fun ChatDataModel.toDomain(): ChatDomainModel {
    return ChatDomainModel(id = id, message = message, type = type)
}