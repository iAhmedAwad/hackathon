package com.trianglz.chatbot.modules.chat.presentation

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.chatbot_sdk.modules.chat.domain.models.enum.SenderType
import com.example.chatbot_sdk.modules.chat.presentation.models.MessageUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import javax.inject.Inject

@HiltViewModel
class ChatScreenViewModel @Inject constructor() : ViewModel() {

    private val defaultExceptionHandler = CoroutineExceptionHandler { _, exception ->

        println("Exception is $exception")
    }

    val chatList: SnapshotStateList<MessageUIModel> = SnapshotStateList()

    init {
        chatList.addAll(getChatList())
    }


    private fun getChatList(): List<MessageUIModel> {

        val list = mutableListOf<MessageUIModel>()

        list.apply {
            add(MessageUIModel(id = "adfgh", content = "Hello 1", type = SenderType.ME))
            add(MessageUIModel(id = "adghw", content = "Hello 1", type = SenderType.OTHER))
            add(MessageUIModel(id = "addfgh", content = "Hello 1", type = SenderType.ME))
            add(MessageUIModel(id = "afghs", content = "Hello 1", type = SenderType.OTHER))
            add(MessageUIModel(id = "asfdgxg", content = "Hello 1", type = SenderType.ME))
            add(MessageUIModel(id = "kvba", content = "Hello 1", type = SenderType.OTHER))
            add(MessageUIModel(id = "cxvbsa", content = "Hello 1", type = SenderType.ME))
            add(MessageUIModel(id = "ogxcvba", content = "Hello 1", type = SenderType.OTHER))
            add(MessageUIModel(id = "avxcvbgf", content = "Hello 1", type = SenderType.ME))
        }

        return list

    }


}