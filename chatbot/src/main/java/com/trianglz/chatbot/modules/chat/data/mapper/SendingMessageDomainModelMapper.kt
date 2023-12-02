package com.trianglz.chatbot.modules.chat.data.mapper

import com.trianglz.chatbot.modules.chat.data.remote.retrofit.models.request.SendingMessageRequestModel
import com.trianglz.chatbot.modules.chat.domain.models.SendingMessageDomainModel

/**
 * @author Awad for TrianglZ
 * Created 12/2/2023 at 1:16 PM
 */

fun SendingMessageDomainModel.toRequest(): SendingMessageRequestModel {
    return SendingMessageRequestModel(message)
}