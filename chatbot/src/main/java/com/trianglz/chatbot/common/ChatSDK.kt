package com.trianglz.chatbot.common

import androidx.compose.ui.graphics.Color


object SDK {
    var primaryColor: Color = Color.Red
    var userChatColor: Color = Color.White
    var botChatColor: Color = Color.White
    var botBackgroundColor: Color = Color.White
    var userBackgroundColor: Color = Color.White

    fun init(
        primaryColor: Color,
        userChatColor: Color = Color.White,
        botChatColor: Color = Color.White,
        botBackgroundColor: Color = Color.White,
        userBackgroundColor: Color = Color.White,
    ) {
        this.primaryColor = primaryColor
        this.userChatColor = userChatColor
        this.botChatColor = botChatColor
        this.botBackgroundColor = botBackgroundColor
        this.userBackgroundColor = userBackgroundColor
    }
}