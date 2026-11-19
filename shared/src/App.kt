package com.zhchmmx.welearn

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.zhchmmx.welearn.route.Login
import com.zhchmmx.welearn.screen.MainScreen
import org.jetbrains.compose.reload.DevelopmentEntryPoint
import com.zhchmmx.welearn.route.Main
import com.zhchmmx.welearn.screen.LoginScreen

@Composable
@Preview
@DevelopmentEntryPoint
fun App() {
    MaterialTheme {
        val backstack = remember { mutableStateListOf<NavKey>(Main) }
        NavDisplay(
            backStack = backstack,
            onBack = { backstack.removeLastOrNull() },//TODO 考虑要不要删掉这个，这样从这里吞掉返回。
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
