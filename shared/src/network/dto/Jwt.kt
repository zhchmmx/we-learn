package com.zhchmmx.welearn.network.dto

import kotlinx.serialization.Serializable

/** JWT */
@Serializable
data class JwtDto(
    /** JWT encoded string. */
    val jwt: String
)
