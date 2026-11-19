package com.zhchmmx.welearn.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** Session */
@Serializable
data class Session(
    /** Session ID. */
    @SerialName("\$id")
    val id: String,

    /** Session creation date in ISO 8601 format. */
    @SerialName("\$createdAt")
    val createdAt: String,

    /** Session update date in ISO 8601 format. */
    @SerialName("\$updatedAt")
    val updatedAt: String,

    /** User ID. */
    val userId: String,

    /** Name of the user the session belongs to. Lets a client label the account, for example in an account switcher. */
    val userName: String,

    /** Session expiration date in ISO 8601 format. */
    val expire: String,

    /** Session Provider. */
    val provider: String,

    /** Session Provider User ID. */
    val providerUid: String,

    /** Session Provider Access Token. */
    val providerAccessToken: String,

    /** The date of when the access token expires in ISO 8601 format. */
    val providerAccessTokenExpiry: String,

    /** Session Provider Refresh Token. */
    val providerRefreshToken: String,

    /** IP in use when the session was created. */
    val ip: String,

    /** Operating system code name. View list of [available options](https://github.com/appwrite/appwrite/blob/master/docs/lists/os.json). */
    val osCode: String,

    /** Operating system name. */
    val osName: String,

    /** Operating system version. */
    val osVersion: String,

    /** Client type. */
    val clientType: String,

    /** Client code name. View list of [available options](https://github.com/appwrite/appwrite/blob/master/docs/lists/clients.json). */
    val clientCode: String,

    /** Client name. */
    val clientName: String,

    /** Client version. */
    val clientVersion: String,

    /** Client engine name. */
    val clientEngine: String,

    /** Client engine name. */
    val clientEngineVersion: String,

    /** Device name. */
    val deviceName: String,

    /** Device brand name. */
    val deviceBrand: String,

    /** Device model name. */
    val deviceModel: String,

    /** Country two-character ISO 3166-1 alpha code. */
    val countryCode: String,

    /** Country name. */
    val countryName: String,

    /** Returns true if this the current user session. */
    val current: Boolean,

    /** Returns a list of active session factors. */
    val factors: List<String>,

    /** Secret used to authenticate the user. Only included if the request was made with an API key */
    val secret: String,

    /** Most recent date in ISO 8601 format when the session successfully passed MFA challenge. */
    val mfaUpdatedAt: String
)
