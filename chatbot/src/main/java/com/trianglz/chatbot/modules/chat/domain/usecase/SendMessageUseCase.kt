package com.trianglz.chatbot.modules.chat.domain.usecase

import com.trianglz.chatbot.modules.chat.data.repo.ChatBotRepoImpl
import com.trianglz.chatbot.modules.chat.domain.models.ChatDomainModel
import com.trianglz.chatbot.modules.chat.domain.models.SendingMessageDomainModel

/**
 * @author Awad for TrianglZ
 * Created 12/2/2023 at 1:17 PM
 */
class SendMessageUseCase {

    private val repo = ChatBotRepoImpl()
    suspend fun execute(message: SendingMessageDomainModel): ChatDomainModel {
        return repo.sendMessage(message = message)
    }
}