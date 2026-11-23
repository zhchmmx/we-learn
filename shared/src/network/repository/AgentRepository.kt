package com.zhchmmx.welearn.network.repository

import com.zhchmmx.welearn.network.client.agentHttpClient
import com.zhchmmx.welearn.network.dto.SessionMessage
import io.ktor.client.call.body
import io.ktor.client.request.get

class AgentRepository {
    suspend fun getChatHistory(threadId: String): List<SessionMessage> {
        return agentHttpClient
            .get("$threadId/get-messages")
            .body<List<SessionMessage>>()
    }
}