package com.zhchmmx.welearn.network.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class SessionMessagePart(
    val type: String,
    val text: String? = null,
    val reasoning: String? = null,
    val toolCallId: String? = null,
    val toolName: String? = null,
    val input: JsonElement? = null,
    val output: JsonElement? = null,
    val state: String? = null,
    val result: JsonElement? = null,
    val mediaType: String? = null,
    val url: String? = null,
    val filename: String? = null,

)
