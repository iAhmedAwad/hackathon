package com.trianglz.chatbot.modules.chat.data.remote.retrofit.models.response


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import androidx.annotation.Keep

@Keep
@JsonClass(generateAdapter = true)
data class RecommendationDataModel(
    @Json(name = "id")
    val id: Int?,
)