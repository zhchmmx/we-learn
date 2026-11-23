package com.zhchmmx.welearn.network.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class SessionMessage(
    val id: String,
    val role: String,
    val parts: List<SessionMessagePart>,
    val metadata: JsonElement? = null,
    val createdAt: String? = null,
)
