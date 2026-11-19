package com.zhchmmx.welearn.viewmodel

import androidx.lifecycle.ViewModel
import com.zhchmmx.welearn.model.User
import com.zhchmmx.welearn.service.AuthService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class UserViewModel : ViewModel() {
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user.asStateFlow()

    suspend fun login(username: String, password: String) {
        val authService = AuthService()
        _isLoading.value = true
        try {
            _user.value = authService.login(username, password)
        }
        finally {
            _isLoading.value = false
        }
    }
}