package com.zhchmmx.welearn.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class AppwriteError(
    val message: String = "",
    val type: String = "",
    val code: Int = 0,
)
