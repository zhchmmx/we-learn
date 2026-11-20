package com.zhchmmx.welearn.ui.screeen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AiScreen(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {}
    ) { innerPadding ->
        AiScreenContent(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun AiScreenContent(modifier: Modifier = Modifier) {

}