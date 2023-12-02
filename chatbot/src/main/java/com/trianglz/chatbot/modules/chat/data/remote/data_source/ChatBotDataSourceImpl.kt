package com.trianglz.chatbot.modules.chat.data.remote.data_source

import com.example.chatbot_sdk.modules.chat.domain.models.enum.SenderType
import com.trianglz.chatbot.modules.chat.data.mapper.toData
import com.trianglz.chatbot.modules.chat.data.models.ChatDataModel
import com.trianglz.chatbot.modules.chat.data.remote.retrofit.models.request.SendingMessageRequestModel
import com.trianglz.chatbot.modules.chat.data.remote.retrofit.service.ChatBotService
import kotlinx.coroutines.delay
import javax.inject.Inject

/**
 * @author Awad for TrianglZ
 * Created 12/2/2023 at 12:20 PM
 */
class ChatBotDataSourceImpl @Inject constructor(private val service: ChatBotService) : ChatBotDataSource {
    override suspend fun sendMessage(message: SendingMessageRequestModel): ChatDataModel {

        //delay(2000)
        //return ChatDataModel(System.identityHashCode(this),"this is the bot response...",SenderType.OTHER)
        return  service.sendMessage(message.message).toData()
    }
}