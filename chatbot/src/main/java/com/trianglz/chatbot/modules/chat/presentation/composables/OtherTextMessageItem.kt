package com.trianglz.chatbot.modules.chat.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.trianglz.chatbot.modules.chat.presentation.models.ChatUIModel

@Composable
fun OtherTextMessageItem(
    chatUIModel: ChatUIModel,
    botChatColor: () -> Color,
    botBackgroundColor: () -> Color
) {
    val bubbleModifier = Modifier
        .graphicsLayer {
            //shape = MessageShape(10.dp.toPx(), BubbleDirection.Start)
            clip = true
        }
    val chatModifier = /*if (messageUIModel.hasBubble) bubbleModifier else */
        Modifier.padding(start = 12.dp)
    val contentPadding =
        /* if (messageUIModel.hasBubble) PaddingValues(start = 24.dp, end = 12.dp, top = 6.dp, bottom = 6.dp) else */
        PaddingValues(horizontal = 12.dp, vertical = 6.dp)

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .wrapContentWidth(align = Start)
                .then(chatModifier)
                .background(botBackgroundColor(), shape = MaterialTheme.shapes.medium)
                .clip(MaterialTheme.shapes.medium)
                .padding(contentPadding),
        ) {
            Text(
                text = chatUIModel.content ?: "",
                style = MaterialTheme.typography.bodyMedium.copy(color = botChatColor()),
                textAlign = TextAlign.Start,
                )

        }
        Spacer(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(0.2f)
        )
    }
}