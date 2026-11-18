package com.zhchmmx.welearn

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
