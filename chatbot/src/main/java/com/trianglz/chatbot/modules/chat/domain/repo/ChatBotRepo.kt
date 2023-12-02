package com.trianglz.chatbot.modules.chat.domain.repo

import com.trianglz.chatbot.modules.chat.domain.models.ChatDomainModel
import com.trianglz.chatbot.modules.chat.domain.models.SendingMessageDomainModel

/**
 * @author Awad for TrianglZ
 * Created 12/2/2023 at 1:07 PM
 */
interface ChatBotRepo {
    suspend fun sendMessage(message: SendingMessageDomainModel): ChatDomainModel
}