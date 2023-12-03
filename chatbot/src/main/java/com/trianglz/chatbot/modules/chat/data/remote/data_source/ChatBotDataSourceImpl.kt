package com.trianglz.chatbot.modules.chat.data.remote.data_source

import com.trianglz.chatbot.common.data.service.APIService
import com.trianglz.chatbot.modules.chat.data.mapper.toData
import com.trianglz.chatbot.modules.chat.data.models.ChatDataModel
import com.trianglz.chatbot.modules.chat.data.remote.retrofit.models.request.SendingMessageRequestModel

/**
 * @author Awad for TrianglZ
 * Created 12/2/2023 at 12:20 PM
 */
class ChatBotDataSourceImpl : ChatBotDataSource {

    private val service = APIService.chatBotService
    override suspend fun sendMessage(message: SendingMessageRequestModel): ChatDataModel {

        return service.sendMessage(message.message).toData()
    }
}
