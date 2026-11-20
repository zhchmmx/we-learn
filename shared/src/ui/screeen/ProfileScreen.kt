package com.zhchmmx.welearn.ui.screeen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun ProfileScreen(
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            LargeTopAppBar(
                title = { Text(text = "Profile") },
            )
        }
    ){innerPadding ->
        ProfileContent(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun ProfileContent(
    modifier: Modifier = Modifier
){

}
