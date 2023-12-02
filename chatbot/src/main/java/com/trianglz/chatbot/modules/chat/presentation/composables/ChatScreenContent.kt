package com.trianglz.chatbot.modules.chat.presentation.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.chatbot_sdk.modules.chat.domain.models.enum.SenderType
import com.trianglz.chatbot.modules.chat.presentation.models.ChatUIModel


@Composable
fun ChatScreenContent(
    chatList: State<SnapshotStateList<ChatUIModel>>,
    onSendClicked: (text: String) -> Unit,
    primaryColor: () -> Color,
    userChatColor: () -> Color,
    botChatColor: () -> Color,
    userBackgroundColor: () -> Color,
    botBackgroundColor: () -> Color
) {

    Column(modifier = Modifier.fillMaxSize()) {

        LazyColumn(Modifier.weight(1F)) {
            items(chatList.value.toList()) { message ->
                when (message.type) {
                    SenderType.ME -> MeTextMessageItem(
                        chatUIModel = message,
                        userChatColor = userChatColor, userBackgroundColor = userBackgroundColor
                    )

                    SenderType.OTHER -> OtherTextMessageItem(
                        chatUIModel = message,
                        botChatColor = botChatColor, botBackgroundColor = botBackgroundColor
                    )
                }
            }
        }

        ChatDetailsActionsItem(onSendClicked = onSendClicked, primaryColor = primaryColor)
    }

}