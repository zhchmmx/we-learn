package com.zhchmmx.welearn.network.dto

data class CreateJwt(
    /** Time in seconds before JWT expires. Default duration is 900 seconds, and maximum is 3600 seconds. */
    val duration: Int? = null
)
