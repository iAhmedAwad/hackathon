package com.trianglz.chatbot.modules.chat.data.remote.retrofit.models.response


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import androidx.annotation.Keep

@Keep
@JsonClass(generateAdapter = true)
data class ChatBotResponseModel(
    @Json(name = "recommendations")
    val recommendations: List<RecommendationDataModel>?,
    @Json(name = "response")
    val response: String?
)