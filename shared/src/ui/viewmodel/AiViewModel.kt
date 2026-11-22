package com.zhchmmx.welearn.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zhchmmx.welearn.service.AgentService
import kotlinx.coroutines.launch

class AiViewModel: ViewModel() {
    private val agentService = AgentService()

    fun send(message: String)  {
        viewModelScope.launch {
            agentService.sendMessage(message).collect { event ->
                // Handle the event
            }
        }
    }
}