package com.zhchmmx.welearn.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

/** User */
@Serializable
data class User(
    /** User ID. */
    @SerialName("\$id")
    val id: String,

    /** User creation date in ISO 8601 format. */
    @SerialName("\$createdAt")
    val createdAt: String,

    /** User update date in ISO 8601 format. */
    @SerialName("\$updatedAt")
    val updatedAt: String,

    /** User name. */
    val name: String,

    /** User registration date in ISO 8601 format. */
    val registration: String,

    /** User status. Pass `true` for enabled and `false` for disabled. */
    val status: Boolean,

    /** Labels for the user. */
    val labels: List<String>,

    /** Password update time in ISO 8601 format. */
    val passwordUpdate: String,

    /** User email address. */
    val email: String,

    /** User phone number in E.164 format. */
    val phone: String,

    /** Email verification status. */
    val emailVerification: Boolean,

    /** Phone verification status. */
    val phoneVerification: Boolean,

    /** Multi factor authentication status. */
    val mfa: Boolean,

    /** User preferences as a key-value object */
    val prefs: JsonObject,

    /** A user-owned message receiver. A single user may have multiple e.g. emails, phones, and a browser. Each target is registered with a single provider. */
    val targets: List<Target>,

    /** Most recent access date in ISO 8601 format. This attribute is only updated again after 24 hours. */
    val accessedAt: String,

    /** Hashed user password. */
    val password: String? = null,

    /** Password hashing algorithm. */
    val hash: String? = null,

    /** Password hashing algorithm configuration. */
    val hashOptions: JsonObject? = null,

    /** Canonical form of the user email address. */
    val emailCanonical: String? = null,

    /** Whether the user email is from a free email provider. */
    val emailIsFree: Boolean? = null,

    /** Whether the user email is from a disposable email provider. */
    val emailIsDisposable: Boolean? = null,

    /** Whether the user email is from a corporate domain. */
    val emailIsCorporate: Boolean? = null,

    /** Whether the user email is in its canonical form. */
    val emailIsCanonical: Boolean? = null,

    /** Whether the password was found in a known data breach the last time it was checked. Null when the password has never been checked. */
    val passwordPwned: Boolean? = null,

    /** Whether the user can impersonate other users. */
    val impersonator: Boolean? = null,

    /** ID of the original actor performing the impersonation. Present only when the current request is impersonating another user. Internal audit logs attribute the action to this user, while the impersonated target is recorded only in internal audit payload data. */
    val impersonatorUserId: String? = null
)
