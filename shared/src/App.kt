package com.zhchmmx.welearn

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.zhchmmx.welearn.ui.route.Login
import com.zhchmmx.welearn.ui.screeen.MainScreen
import org.jetbrains.compose.reload.DevelopmentEntryPoint
import com.zhchmmx.welearn.ui.route.Main
import com.zhchmmx.welearn.ui.screeen.LoginScreen
import com.zhchmmx.welearn.ui.viewmodel.UserViewModel

@Composable
@Preview
@DevelopmentEntryPoint
fun App() {
    MaterialTheme {
        val backstack = remember { mutableStateListOf<NavKey>(Main) }
        val userViewModel = viewModel { UserViewModel() }
        val user by userViewModel.user.collectAsStateWithLifecycle()
        LaunchedEffect(user != null) {
            if (user == null) {
                backstack.add(Login)
            }
            else if (user != null) {
                backstack.removeLastOrNull()
                if (backstack.isEmpty()) {
                    backstack.add(Main)
                }
            }
        }
        NavDisplay(
            backStack = backstack,
            onBack = {
                if (backstack.lastOrNull() != Login) {
                    backstack.removeLastOrNull()
                }
            },
            entryProvider = entryProvider {
                entry<Main> { MainScreen() }
                entry<Login> {
                    LoginScreen(userViewModel = userViewModel)
                }
            }
        )
    }
}
