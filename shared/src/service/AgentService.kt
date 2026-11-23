package com.zhchmmx.welearn.service

import com.agui.client.AgUiAgent
import com.agui.core.types.BaseEvent
import com.zhchmmx.welearn.network.repository.AgentRepository
import com.zhchmmx.welearn.network.repository.AuthRepository
import com.zhchmmx.welearn.ui.model.ChatMessage
import kotlinx.coroutines.flow.Flow
import kotlin.uuid.Uuid

private const val AGENT_BASE_URL = "https://agent.welearn.08012026.xyz/agents/chat-agent"

class AgentService() {
    private val authRepository = AuthRepository()
    private val agentRepository = AgentRepository()
    private lateinit var agent: AgUiAgent

    var conversationId: String? = null
        private set

    var threadId: String? = null
        private set

    private suspend fun initialize() {
        val jwt = authRepository.createJwt()
        agent = AgUiAgent(AGENT_BASE_URL){
            bearerToken = jwt
        }
        threadId = "${authRepository.getAccount().id}_${conversationId!!}"
    }

    fun newConversation() {
        conversationId = Uuid.random().toString()
    }

    fun setConversation(conversationId: String) {
        this.conversationId = conversationId
    }

    /// Must be called after setConversation or newConversation
    suspend fun sendMessage(message: String): Flow<BaseEvent> {
        initialize()
        return agent.sendMessage(
            message = message,
            threadId = threadId!!
        )
    }

    suspend fun getChatHistory(): List<ChatMessage> {
        initialize()
        return agentRepository.getChatHistory(threadId!!)
            .filter { it.role == "user" || it.role == "assistant" }
            .map {message ->
                ChatMessage(
                    message.id,
                    message.role,
                    message.parts.filter { it.type == "text" }.mapNotNull { it.text }.joinToString("")
                )
            }
    }

}