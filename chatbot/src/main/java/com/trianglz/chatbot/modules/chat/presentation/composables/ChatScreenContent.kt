package com.trianglz.chatbot.modules.chat.presentation.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import com.example.chatbot_sdk.modules.chat.domain.models.enum.SenderType
import com.example.chatbot_sdk.modules.chat.presentation.models.MessageUIModel


@Composable
fun ChatScreenContent(chatList: State<SnapshotStateList<MessageUIModel>>) {

    LazyColumn(Modifier.fillMaxSize()) {
        items(chatList.value.toList()) { message ->
            when (message.type) {
                SenderType.ME -> MeTextMessageItem(messageUIModel = message)
                SenderType.OTHER -> OtherTextMessageItem(messageUIModel = message)
            }
        }
    }

}