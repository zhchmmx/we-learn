package com.zhchmmx.welearn.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** Target */
@Serializable
data class Target(
    /** Target ID. */
    @SerialName("\$id")
    val id: String,

    /** Target creation time in ISO 8601 format. */
    @SerialName("\$createdAt")
    val createdAt: String,

    /** Target update date in ISO 8601 format. */
    @SerialName("\$updatedAt")
    val updatedAt: String,

    /** Target Name. */
    val name: String,

    /** User ID. */
    val userId: String,

    /** The target provider type. Can be one of the following: `email`, `sms` or `push`. */
    val providerType: String,

    /** The target identifier. */
    val identifier: String,

    /** Is the target expired. */
    val expired: Boolean,

    /** Provider ID. */
    val providerId: String? = null
)
