package com.zhchmmx.welearn.service

import com.zhchmmx.welearn.ui.model.User
import com.zhchmmx.welearn.network.repository.AuthRepository

class AuthService {
    suspend fun login(email: String, password: String): User {
        val authRepository = AuthRepository()
        authRepository.createEmailPasswordSession(email, password)
        val userDto = authRepository.getAccount()
        val user = User(userDto.id, userDto.name, userDto.email, userDto.emailVerification)
        return user
    }
}