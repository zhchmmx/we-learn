package com.zhchmmx.welearn.screens

import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.zhchmmx.welearn.routes.navItems
import org.jetbrains.compose.resources.stringResource

@Composable
fun MainScreen() {
    var selectedIndex by remember { mutableStateOf(1) }
    NavigationSuiteScaffold(
        navigationSuiteItems = {
            navItems.forEachIndexed { index, key ->
                item(
                    selected = index == selectedIndex,
                    onClick = { selectedIndex = index },
                    icon = { key.icon() },
                    label = { Text(text = stringResource(key.labelKey)) }
                )
            }
        }
    ){
        when (selectedIndex) {
            0 -> DocumentsScreen()
            1 -> AiScreen()
            2 -> QuizzesScreen()
        }
    }

}
