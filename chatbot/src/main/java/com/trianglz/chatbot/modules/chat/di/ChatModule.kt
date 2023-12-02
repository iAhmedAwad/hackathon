
package com.trianglz.chatbot.modules.chat.di

import com.trianglz.chatbot.modules.chat.data.remote.data_source.ChatBotDataSource
import com.trianglz.chatbot.modules.chat.data.remote.data_source.ChatBotDataSourceImpl
import com.trianglz.chatbot.modules.chat.data.remote.retrofit.service.ChatBotService
import com.trianglz.chatbot.modules.chat.data.repo.ChatBotRepoImpl
import com.trianglz.chatbot.modules.chat.domain.repo.ChatBotRepo
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
abstract class ChatModule {

    @ViewModelScoped
    @Binds
    abstract fun bindChatBotDataSource(chatBotDataSource: ChatBotDataSourceImpl): ChatBotDataSource


    @ViewModelScoped
    @Binds
    abstract fun bindChatBotRepository(chatBotRepo: ChatBotRepoImpl): ChatBotRepo

    companion object {
        @ViewModelScoped
        @Provides
        fun provideChatBotService(retrofit: Retrofit): ChatBotService =
            retrofit.create(ChatBotService::class.java)
    }
}
