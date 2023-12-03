package com.trianglz.chatbot.common.data.service

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.trianglz.chatbot.modules.chat.data.remote.retrofit.service.ChatBotService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author Awad for TrianglZ
 * Created 12/3/2023 at 7:22 AM
 */

object APIService {

    private const val BASE_URL = "https://f908-41-40-18-85.ngrok-free.app/"

    private val okHttp = OkHttpClient.Builder().addNetworkInterceptor(StethoInterceptor())
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }).callTimeout(15, TimeUnit.SECONDS).readTimeout(15, TimeUnit.SECONDS)
        .writeTimeout(15, TimeUnit.SECONDS).build()

    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    private val retrofit =
        Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(okHttp)
            .build()

    val chatBotService: ChatBotService by lazy {
        retrofit.create(ChatBotService::class.java)
    }

}