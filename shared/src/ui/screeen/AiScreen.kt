package com.zhchmmx.welearn.ui.screeen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.zhchmmx.welearn.resources.Res
import com.zhchmmx.welearn.resources.newConversation
import com.zhchmmx.welearn.resources.openConversationList
import com.zhchmmx.welearn.resources.send
import com.zhchmmx.welearn.ui.model.ChatMessage
import com.zhchmmx.welearn.ui.viewmodel.AiViewModel
import org.jetbrains.compose.resources.stringResource

@Composable
fun AiScreen(modifier: Modifier = Modifier) {
    val viewModel: AiViewModel = viewModel { AiViewModel() }
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    //TODO
                },
                navigationIcon = {
                    IconButton(onClick = {
                        TODO("Open conversation list")
                    }) {
                        Icon(Icons.Default.Menu, contentDescription = stringResource(Res.string.openConversationList))
                    }
                },
                actions = {
                    IconButton(onClick = {
                        viewModel.newConversation()
                    }) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = stringResource(Res.string.newConversation)
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        AiScreenContent(
            modifier = Modifier.padding(innerPadding),
            viewModel = viewModel
        )
    }
}

@Composable
fun AiScreenContent(
    modifier: Modifier = Modifier,
    viewModel: AiViewModel
) {
    Column(modifier = modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(16.dp),
            reverseLayout = true,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(viewModel.state.messages.asReversed(), key = { it.id }) { item ->
                MessageItem(message = item)
            }
        }

        OutlinedTextField(
            value = viewModel.state.input,
            maxLines = 5,
            onValueChange = { viewModel.updateInput(it) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
                .imePadding(),
            trailingIcon = {
                IconButton(onClick = {
                    viewModel.send()
                },
                    enabled = !viewModel.state.isRunning) {
                    Icon(Icons.AutoMirrored.Default.Send, contentDescription = stringResource(Res.string.send))
                }
            }
        )
    }
}

@Composable
fun MessageItem(modifier: Modifier = Modifier, message: ChatMessage) {
    val label = if (message.role == "user") "User" else "Assistant"
    Text(text = "$label: ${message.content}")
}
