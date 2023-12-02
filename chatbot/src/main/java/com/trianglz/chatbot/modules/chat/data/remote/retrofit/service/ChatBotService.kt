package com.trianglz.chatbot.modules.chat.data.remote.retrofit.service

import com.trianglz.chatbot.common.data.ApiPaths.Companion.THE_MATE
import com.trianglz.chatbot.common.data.ApiQueries.Companion.USER_INPUT
import com.trianglz.chatbot.modules.chat.data.remote.retrofit.models.response.ChatBotResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Awad for TrianglZ
 * Created 12/2/2023 at 11:46 AM
 */
interface ChatBotService {
    @GET(THE_MATE)
    suspend fun sendMessage(@Query(USER_INPUT) message: String): ChatBotResponseModel
}