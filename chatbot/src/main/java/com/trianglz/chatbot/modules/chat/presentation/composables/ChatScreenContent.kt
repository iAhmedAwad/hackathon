package com.trianglz.chatbot.modules.chat.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.chatbot_sdk.modules.chat.domain.models.enum.SenderType
import com.trianglz.chatbot.R
import com.trianglz.chatbot.modules.chat.presentation.models.ChatUIModel
import com.trianglz.chatbot.modules.home.ChatBotActivity


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

        ScreenHeader(background = primaryColor)

        LazyColumn(
            Modifier
                .weight(1F)
                .padding(top = 20.dp)
        ) {
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

@Composable
fun ScreenHeader(background: () -> Color) {

    val context = LocalContext.current
    Row(
        Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(background()),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(text = stringResource(id = R.string.finish), modifier = Modifier.padding(horizontal = 20.dp).clickable {
            //(context as? ChatBotActivity)?.finish()
        }, color = Color.White)
    }
}