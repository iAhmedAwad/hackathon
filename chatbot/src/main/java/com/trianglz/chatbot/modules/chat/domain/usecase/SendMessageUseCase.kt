package com.trianglz.chatbot.modules.chat.domain.usecase

import com.trianglz.chatbot.modules.chat.domain.models.ChatDomainModel
import com.trianglz.chatbot.modules.chat.domain.models.SendingMessageDomainModel
import com.trianglz.chatbot.modules.chat.domain.repo.ChatBotRepo
import javax.inject.Inject

/**
 * @author Awad for TrianglZ
 * Created 12/2/2023 at 1:17 PM
 */
class SendMessageUseCase @Inject constructor(private val repo: ChatBotRepo) {

    suspend fun execute(message: SendingMessageDomainModel): ChatDomainModel {
        return repo.sendMessage(message = message)
    }
}