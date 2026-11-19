package com.zhchmmx.welearn.network.repository

import com.zhchmmx.welearn.network.client.appwriteHttpClient
import com.zhchmmx.welearn.network.dto.CreateEmailPasswordSession
import com.zhchmmx.welearn.network.dto.Session
import com.zhchmmx.welearn.network.dto.User
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody

class AuthRepository {
    suspend fun createEmailPasswordSession(email: String, password: String): Session {
        return appwriteHttpClient.post("account/sessions/email") {
            setBody(CreateEmailPasswordSession(email = email, password = password))
        }.body<Session>()
    }

    suspend fun getAccount(): User {
        return appwriteHttpClient.get("account").body<User>()
    }
}