package com.trianglz.chatbot.modules.chat.data.repo

import com.trianglz.chatbot.modules.chat.data.mapper.toDomain
import com.trianglz.chatbot.modules.chat.data.mapper.toRequest
import com.trianglz.chatbot.modules.chat.data.remote.data_source.ChatBotDataSource
import com.trianglz.chatbot.modules.chat.domain.models.ChatDomainModel
import com.trianglz.chatbot.modules.chat.domain.models.SendingMessageDomainModel
import com.trianglz.chatbot.modules.chat.domain.repo.ChatBotRepo
import javax.inject.Inject

/**
 * @author Awad for TrianglZ
 * Created 12/2/2023 at 1:11 PM
 */
class ChatBotRepoImpl @Inject constructor(private val dataSource: ChatBotDataSource) : ChatBotRepo {
    override suspend fun sendMessage(message: SendingMessageDomainModel): ChatDomainModel {
        return dataSource.sendMessage(message.toRequest()).toDomain()
    }
}