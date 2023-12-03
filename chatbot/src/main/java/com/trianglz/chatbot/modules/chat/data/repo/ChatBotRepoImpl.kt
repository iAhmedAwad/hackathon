package com.trianglz.chatbot.modules.chat.data.repo

import com.trianglz.chatbot.modules.chat.data.mapper.toDomain
import com.trianglz.chatbot.modules.chat.data.mapper.toRequest
import com.trianglz.chatbot.modules.chat.data.remote.data_source.ChatBotDataSourceImpl
import com.trianglz.chatbot.modules.chat.domain.models.ChatDomainModel
import com.trianglz.chatbot.modules.chat.domain.models.SendingMessageDomainModel
import com.trianglz.chatbot.modules.chat.domain.repo.ChatBotRepo

/**
 * @author Awad for TrianglZ
 * Created 12/2/2023 at 1:11 PM
 */
class ChatBotRepoImpl : ChatBotRepo {
    private val dataSource = ChatBotDataSourceImpl()
    override suspend fun sendMessage(message: SendingMessageDomainModel): ChatDomainModel {
        return dataSource.sendMessage(message.toRequest()).toDomain()
    }
}