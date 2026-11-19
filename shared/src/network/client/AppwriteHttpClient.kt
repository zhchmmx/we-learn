package com.zhchmmx.welearn.network.client

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.cookies.HttpCookies
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

val appwriteHttpClient = HttpClient {
    expectSuccess = true
    install(ContentNegotiation) {
        json(Json { ignoreUnknownKeys = true })
    }
    install(HttpCookies)
    install(Logging) { level = LogLevel.BODY }
    defaultRequest {
        url("https://sgp.cloud.appwrite.io/v1/")
        header("X-Appwrite-Project", "6a6c7036001a06ffc393")
        header("Content-Type", "application/json")
    }
}