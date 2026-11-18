package com.zhchmmx.welearn.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.KeyboardActionHandler
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedSecureTextField
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.zhchmmx.welearn.resources.Res
import com.zhchmmx.welearn.resources.email
import com.zhchmmx.welearn.resources.login
import com.zhchmmx.welearn.resources.loginWelcome
import com.zhchmmx.welearn.resources.password
import com.zhchmmx.welearn.resources.signUp
import org.jetbrains.compose.resources.stringResource

private const val SIGN_UP_URL = "https://account.08012026.xyz/register"

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    isLoading: Boolean = false,
    onLogin: (email: String, password: String) -> Unit = { _, _ -> }
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = stringResource(Res.string.login)) })
        }
    ) { innerPadding ->
        LoginContent(
            modifier = Modifier.padding(innerPadding),
            isLoading = isLoading,
            onLogin = onLogin
        )
    }
}

@Composable
private fun LoginContent(
    modifier: Modifier = Modifier,
    isLoading: Boolean,
    onLogin: (email: String, password: String) -> Unit
) {
    val uriHandler = LocalUriHandler.current
    val emailState = rememberTextFieldState()
    val passwordState = rememberTextFieldState()
    val passwordFocusRequester = remember { FocusRequester() }
    val submit = {
        onLogin(emailState.text.toString(), passwordState.text.toString())
    }
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(0.8f),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = stringResource(Res.string.loginWelcome),
                style = MaterialTheme.typography.displaySmall
            )
            OutlinedTextField(
                state = emailState,
                label = { Text(text = stringResource(Res.string.email)) },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                onKeyboardAction = KeyboardActionHandler {
                    passwordFocusRequester.requestFocus()
                }
            )
            OutlinedSecureTextField(
                state = passwordState,
                label = { Text(text = stringResource(Res.string.password)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(passwordFocusRequester),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                onKeyboardAction = KeyboardActionHandler { default ->
                    submit()
                    default()
                }
            )
            Row {
                Button(onClick = submit) {
                    Text(text = stringResource(Res.string.login))
                }
                TextButton(
                    onClick = { uriHandler.openUri(SIGN_UP_URL) },
                    modifier = Modifier.padding(horizontal = 12.dp)
                ) {
                    Text(text = stringResource(Res.string.signUp))
                }
            }
        }
        if (isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colorScheme.background)
                    .pointerInput(Unit) {
                        awaitEachGesture {
                            awaitPointerEvent().changes.forEach { it.consume() }
                        }
                    }
            ) {
                CircularProgressIndicator(modifier = Modifier.align(alignment = Alignment.Center))
            }
        }
    }
}
