package com.trianglz.chatbot.modules.chat.presentation.models

/**
 * @author Awad for TrianglZ
 * Created 12/2/2023 at 3:18 PM
 */
sealed class LoadingState {
    data object Idle : LoadingState()
    data object Loading : LoadingState()
    data class Error(val errorMessage: String) : LoadingState()
}