package com.trianglz.chatbot.modules.chat.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.chatbot_sdk.modules.chat.domain.models.enum.SenderType
import com.trianglz.chatbot.common.SDK
import com.trianglz.chatbot.modules.chat.presentation.composables.ChatScreenContent

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ChatScreen(
    viewModel: ChatScreenViewModel = hiltViewModel()
) {

    val chatList = remember {
        derivedStateOf {
            viewModel.chatList
        }
    }

    val primaryColor = remember {
        {
            SDK.primaryColor
        }
    }

    val botChatColor = remember {
        {
            SDK.botChatColor
        }
    }

    val userChatColor = remember {
        {
            SDK.userChatColor
        }
    }

    val userBackgroundColor = remember {
        {
            SDK.userBackgroundColor
        }
    }

    val botBackgroundColor = remember {
        {
            SDK.botBackgroundColor
        }
    }

    val keyboard = LocalSoftwareKeyboardController.current

    val onSendClicked: (String) -> Unit = remember {
        {
            viewModel.sendMessage(it)
            keyboard?.hide()
        }
    }

    ChatScreenContent(
        chatList,
        onSendClicked = onSendClicked,
        primaryColor = primaryColor,
        userChatColor = userChatColor,
        botChatColor = botChatColor,
        userBackgroundColor = userBackgroundColor,
        botBackgroundColor = botBackgroundColor
    )
}


@Composable
fun MeMessage(message: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.End
    ) {
        MessageBubble(
            message = message,
            senderType = SenderType.ME
        )
    }
}

@Composable
fun OtherMessage(message: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        MessageBubble(
            message = message,
            senderType = SenderType.OTHER
        )
    }
}

@Composable
fun MessageBubble(message: String, senderType: SenderType) {
    val backgroundColor = if (senderType == SenderType.ME) {
        Color.Blue // Change color as needed for the sender
    } else {
        Color.Green // Change color as needed for the other person
    }

    Surface(
        shape = RoundedCornerShape(8.dp),
        color = backgroundColor,
        modifier = Modifier.padding(8.dp)
    ) {
        Text(
            text = message,
            color = Color.White,
            modifier = Modifier.padding(8.dp),
            textAlign = if (senderType == SenderType.ME) TextAlign.End else TextAlign.Start
        )
    }
}
