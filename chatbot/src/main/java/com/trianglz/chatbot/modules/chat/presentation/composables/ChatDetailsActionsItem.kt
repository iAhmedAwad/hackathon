package com.trianglz.chatbot.modules.chat.presentation.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.trianglz.chatbot.R

@Composable
fun ChatDetailsActionsItem(onSendClicked: (text: String) -> Unit, primaryColor: () -> Color) {
    var text by rememberSaveable { mutableStateOf("") }
    Row(
        modifier = Modifier
            .navigationBarsPadding()
            .imePadding()
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(
                horizontal = 20.dp,
                vertical = 10.dp
            )
            .border(BorderStroke(1.dp, primaryColor()), shape = MaterialTheme.shapes.medium),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        ChatOutlineTextField(
            modifier = Modifier
                .padding(0.dp)
                .heightIn(min = 40.dp)
                .weight(1f)
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = MaterialTheme.shapes.medium
                )
                .clip(MaterialTheme.shapes.medium),
            value = text,
            textStyle = MaterialTheme.typography.bodyMedium,
            onValueChange = {
                text = it
            },

            maxLines = 3,
            placeholder = {
                Text(
                    stringResource(id = R.string.type_your_message),
                    style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.secondary)
                )
            },
            trailingIcon = {
                AnimatedVisibility(
                    visible = true,
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {

                    Icon(
                        modifier = Modifier
                            .size(32.dp)
                            .background(color = primaryColor(), shape = CircleShape)
                            .clip(CircleShape)
                            .clickable {
                                onSendClicked(text)
                                text = ""
                            }
                            .padding(8.dp),
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_send),
                        contentDescription = "show attach button",
                        tint = Color.Yellow
                    )
                }
            },

            shape = MaterialTheme.shapes.medium,
            contentPadding = PaddingValues(vertical = 16.dp, horizontal = 16.dp),
        )


    }

}