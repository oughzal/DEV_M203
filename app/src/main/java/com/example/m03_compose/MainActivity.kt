package com.example.m03_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                MainScreen()
            }


        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PHONE
)
@Composable
fun MainScreen() {
    var pagerState = rememberPagerState(pageCount = { 3 })
    val scope = rememberCoroutineScope()
    Scaffold(
        topBar = { TopAppBarScreen() },
        bottomBar = {
            BottomAppBarScreen(pagerState) { index ->
                scope.launch {
                    pagerState.scrollToPage(index)
                }

            }
        },
        content = { ContentScreen(pagerState, it) }
    )

}

@Composable
fun ContentScreen(pagerState: PagerState, padding: PaddingValues) {

    HorizontalPager(
        state = pagerState,
        modifier = Modifier.padding(padding)
    ) { page ->
        when (page) {
            0 -> ChatSreen()
            1 -> StatusScreen()
            2 -> CallScreen()
        }

    }
}

@Composable
fun CallScreen() {
    Text(
        textAlign = TextAlign.Center,
        text = "Call Screen",
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun StatusScreen() {
    Text(
        textAlign = TextAlign.Center,
        text = "Status Screen",
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun ChatSreen() {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(conversations){
            ConversationItem(conversation = it)
        }
    }
}

@Composable
fun ConversationItem(conversation: Conversation) {
    Row(
        modifier = Modifier.clickable( onClick = {  })
    ) {
        Image(
            painter = painterResource(conversation.profilImage),
            contentDescription = null,
            modifier = Modifier
                .width(80.dp)
                .aspectRatio(1f)
                .clip(CircleShape)
                .border(BorderStroke(width = 3.dp, color = Color.Green), shape = CircleShape)
        )
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(8.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = conversation.name,
                    modifier = Modifier.weight(1f),
                    fontWeight = FontWeight.Bold
                )
                Text(text = conversation.time)
            }
            Text(text = conversation.lastMessage)
        }
    }
}

@Composable
fun BottomAppBarScreen(pagerState: PagerState,onClick: (Int) -> Unit = {}) {
    NavigationBar {
        navigationBarItems.forEachIndexed { i, item ->
            val selected = pagerState.currentPage == i
            NavigationBarItem(
                selected = selected,
                label = {
                    Text(
                        text = item.title,
                        fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal,
                        color = if (selected) Color.Black else Color.Gray

                    )
                },
                onClick = { onClick(i) },
                icon = {
                    Icon(
                        imageVector = if (selected) item.selectedIcon else item.icon,
                        contentDescription = null,
                        tint = if (selected) Color.Black else Color.Gray
                    )
                }
            )

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarScreen() {
    TopAppBar(
        title = { Text(text = "Whatsapp") },
        actions = {
            IconButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Outlined.CameraAlt, contentDescription = null
                )
            }

            MainMenu() { index ->

            }
        }
    )
}

@Composable
fun MainMenu(onClick: (index: Int) -> Unit = {}) {
    var expanded by remember { mutableStateOf(false) }
    Box {
        IconButton(
            onClick = {
                expanded = true
            }
        ) {
            Icon(
                imageVector = Icons.Outlined.MoreVert, contentDescription = null
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            mainMenuItems.forEachIndexed { index, item ->
                DropdownMenuItem(
                    text = { Text("${item.title}") },
                    onClick = {
                        onClick(index)
                        expanded = false
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = null,
                            tint = Color.Black
                        )
                    },
                    trailingIcon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = null,
                            tint = Color.Black
                        )
                    }
                )
            }


        }
    }
}


