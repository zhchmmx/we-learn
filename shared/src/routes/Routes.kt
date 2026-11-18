package com.zhchmmx.welearn.routes

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavKey
import com.zhchmmx.welearn.resources.Res
import com.zhchmmx.welearn.resources.ai
import com.zhchmmx.welearn.resources.documents
import com.zhchmmx.welearn.resources.quizzes
import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource


@Serializable object Main: NavKey

@Serializable object Login: NavKey

@Serializable object Documents: NavKey

@Serializable object Ai: NavKey

@Serializable object Quizzes: NavKey



data class NavItem(
    val key:NavKey,
    val labelKey: StringResource,
    val icon: @Composable () -> Unit
)

val navItems = listOf(
    NavItem(Documents, Res.string.documents, {
        Icon(Icons.Default.Description, stringResource(Res.string.documents))
    }),
    NavItem(Ai, Res.string.ai, {
        Icon(Icons.Default.AutoAwesome, stringResource(Res.string.ai))
    }),
    NavItem(Quizzes, Res.string.quizzes, {
        Icon(Icons.Default.Quiz, stringResource(Res.string.quizzes))
    })
)