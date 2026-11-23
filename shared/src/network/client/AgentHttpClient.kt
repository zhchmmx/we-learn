package com.zhchmmx.welearn.network.client

import com.zhchmmx.welearn.network.repository.AuthRepository
import io.ktor.client.HttpClient
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

val agentHttpClient = HttpClient {
    expectSuccess = true
    install(ContentNegotiation) {
        json(Json { ignoreUnknownKeys = true })
    }
    install(Auth) {
        bearer {
            sendWithoutRequest { true }
            loadTokens { BearerTokens(AuthRepository().createJwt(), "") }
            refreshTokens { BearerTokens(AuthRepository().createJwt(), "") }
        }
    }
    defaultRequest {
        url("https://agent.welearn.08012026.xyz/agents/chat-agent/")
    }
}