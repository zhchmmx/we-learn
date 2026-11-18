package com.zhchmmx.welearn

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.zhchmmx.welearn.routes.Login
import com.zhchmmx.welearn.screens.MainScreen
import org.jetbrains.compose.reload.DevelopmentEntryPoint
import com.zhchmmx.welearn.routes.Main
import com.zhchmmx.welearn.screens.LoginScreen

@Composable
@Preview
@DevelopmentEntryPoint
fun App() {
    MaterialTheme {
        val backstack = remember { mutableStateListOf<NavKey>(Main) }
        NavDisplay(
            backStack = backstack,
            onBack = { backstack.removeLastOrNull() },
            entryProvider = entryProvider {
                entry<Main> { MainScreen() }
                entry<Login> {
                    LoginScreen(
                        onLogin = { _, _ ->
                            // TODO：认证逻辑未接入，点击登录直接回到 Main
                            backstack.removeLastOrNull()
                            if (backstack.isEmpty()) backstack.add(Main)
                        }
                    )
                }
            }
        )
    }
}
