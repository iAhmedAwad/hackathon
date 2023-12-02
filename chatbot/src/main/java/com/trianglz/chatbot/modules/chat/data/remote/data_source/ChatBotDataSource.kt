package com.trianglz.chatbot.modules.chat.data.remote.data_source

import com.trianglz.chatbot.modules.chat.data.models.ChatDataModel
import com.trianglz.chatbot.modules.chat.data.remote.retrofit.models.request.SendingMessageRequestModel

/**
 * @author Awad for TrianglZ
 * Created 12/2/2023 at 12:14 PM
 */
interface ChatBotDataSource {
    suspend fun sendMessage(message: SendingMessageRequestModel): ChatDataModel
}