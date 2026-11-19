package com.zhchmmx.welearn.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class CreateEmailPasswordSession(
    /** User email. */
    val email: String,
    /** User password. Must be at least 8 chars. */
    val password: String,
    /** Session length in seconds. Minimum is 60 seconds, and it cannot exceed the project maximum session length. Defaults to the project maximum session length. */
    val duration: Int? = null
)