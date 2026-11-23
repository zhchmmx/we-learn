package com.zhchmmx.welearn.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.agui.core.types.TextMessageContentEvent
import com.agui.core.types.TextMessageStartEvent
import com.zhchmmx.welearn.service.AgentService
import com.zhchmmx.welearn.ui.model.ChatMessage
import kotlinx.coroutines.launch
import kotlin.uuid.Uuid


data class ChatUiState(
    val messages: List<ChatMessage> = emptyList(),
    val input: String = "",
    val isRunning: Boolean = false,
)


class AiViewModel : ViewModel() {
    private val agentService = AgentService()

    var state by mutableStateOf(ChatUiState())
        private set

    init {
        viewModelScope.launch {
            if (agentService.conversationId == null) {
                agentService.newConversation()
            }
            state = state.copy(messages = agentService.getChatHistory())
        }
    }

    fun updateInput(text: String) {
        state = state.copy(input = text)
    }


    fun newConversation() {
        agentService.newConversation()
        state = ChatUiState()
    }


    fun send() {
        val text = state.input.trim()
        if (text.isEmpty() || state.isRunning) return
        state = state.copy(
            messages = state.messages + ChatMessage(Uuid.random().toString(), "user", text),
            input = "",
            isRunning = true,
        )
        viewModelScope.launch {
            try {
                agentService.sendMessage(text).collect { event ->
                    when (event) {
                        is TextMessageStartEvent -> {
                            state = state.copy(
                                messages = state.messages + ChatMessage(
                                    event.messageId,
                                    "assistant",
                                    "",
                                ),
                            )
                        }
                        is TextMessageContentEvent -> state = state.copy(
                            messages = state.messages.map {
                                if (it.id == event.messageId) {
                                    it.copy(content = it.content + event.delta)
                                } else {
                                    it
                                }
                            },
                        )
                        else -> Unit
                    }
                }
            } finally {
                state = state.copy(isRunning = false)
            }
        }
    }
}