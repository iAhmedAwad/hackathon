package com.trianglz.chatbot.modules.chat.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatbot_sdk.modules.chat.domain.models.enum.SenderType
import com.trianglz.chatbot.modules.chat.domain.models.SendingMessageDomainModel
import com.trianglz.chatbot.modules.chat.domain.usecase.SendMessageUseCase
import com.trianglz.chatbot.modules.chat.presentation.mapper.toUI
import com.trianglz.chatbot.modules.chat.presentation.models.ChatUIModel
import com.trianglz.chatbot.modules.chat.presentation.models.LoadingState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


class ChatScreenViewModel :
    ViewModel() {

    private val sendMessageUseCase = SendMessageUseCase()
    val loadingState: MutableState<LoadingState> = mutableStateOf(LoadingState.Idle)


    private val defaultExceptionHandler = CoroutineExceptionHandler { _, exception ->

        loadingState.value = LoadingState.Error(exception.message.orEmpty())
    }

    val chatList: SnapshotStateList<ChatUIModel> = SnapshotStateList()

    init {
        launchCoroutine {
            sendMessage("")
        }
    }

    private fun launchCoroutine(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch(defaultExceptionHandler) {
            block()
        }
    }

    fun sendMessage(message: String) {
        launchCoroutine {
            setLoading()
            val messageDomainModel = SendingMessageDomainModel(message)
            if (message.isNotEmpty()) {
                val userInput = ChatUIModel(content = message, type = SenderType.ME)
                chatList.add(userInput)
            }
            val botResponse = sendMessageUseCase.execute(messageDomainModel)
            chatList.add(botResponse.toUI())
            setDoneLoading()
        }
    }

    private fun setLoading() {
        loadingState.value = LoadingState.Loading
    }

    private fun setDoneLoading() {
        loadingState.value = LoadingState.Idle
    }
}