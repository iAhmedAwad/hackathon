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
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatScreenViewModel @Inject constructor(private val sendMessageUseCase: SendMessageUseCase) :
    ViewModel() {

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


    private fun getChatList(): List<ChatUIModel> {

        val list = mutableListOf<ChatUIModel>()

        list.apply {
//            add(ChatUIModel(id = "adfgh", content = "Hello 1", type = SenderType.ME))
//            add(ChatUIModel(id = "adghw", content = "Hello 1", type = SenderType.OTHER))
//            add(ChatUIModel(id = "addfgh", content = "Hello 1", type = SenderType.ME))
//            add(ChatUIModel(id = "afghs", content = "Hello 1", type = SenderType.OTHER))
//            add(ChatUIModel(id = "asfdgxg", content = "Hello 1", type = SenderType.ME))
//            add(ChatUIModel(id = "kvba", content = "Hello 1", type = SenderType.OTHER))
//            add(ChatUIModel(id = "cxvbsa", content = "Hello 1", type = SenderType.ME))
//            add(ChatUIModel(id = "ogxcvba", content = "Hello 1", type = SenderType.OTHER))
//            add(ChatUIModel(id = "avxcvbgf", content = "Hello 1", type = SenderType.ME))
        }

        return list

    }


}