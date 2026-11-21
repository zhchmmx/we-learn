package com.zhchmmx.welearn.network.repository

import com.zhchmmx.welearn.network.client.appwriteHttpClient
import com.zhchmmx.welearn.network.dto.CreateEmailPasswordSession
import com.zhchmmx.welearn.network.dto.CreateJwt
import com.zhchmmx.welearn.network.dto.JwtDto
import com.zhchmmx.welearn.network.dto.Session
import com.zhchmmx.welearn.network.dto.User
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import kotlinx.serialization.descriptors.PrimitiveKind

class AuthRepository {
    suspend fun createEmailPasswordSession(email: String, password: String): Session {
        return appwriteHttpClient.post("account/sessions/email") {
            setBody(CreateEmailPasswordSession(email = email, password = password))
        }.body<Session>()
    }

    suspend fun getAccount(): User {
        return appwriteHttpClient.get("account").body<User>()
    }

    suspend fun createJwt(): String{
        return appwriteHttpClient.post("account/jwts"){
            setBody(CreateJwt(duration = 900))
        }.body<JwtDto>().jwt
    }
}