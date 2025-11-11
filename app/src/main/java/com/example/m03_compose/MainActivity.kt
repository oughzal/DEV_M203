package com.example.m03_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Groups
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.Button
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview


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
    Scaffold(
        topBar = { TopAppBarScreen() },
        bottomBar = { BottomAppBarScreen(){ index ->

        } },
        content = { ContentScreen(it) }
    )

}

@Composable
fun ContentScreen(p: PaddingValues) {

}

@Composable
fun BottomAppBarScreen( onClick: (Int) -> Unit ={}) {
    NavigationBar {
        navigationBarItems.forEachIndexed { i, item ->
            NavigationBarItem(
                selected = item.selected,
                label = {
                    Text(
                        text = item.title,
                        fontWeight = if(item.selected) FontWeight.Bold else FontWeight.Normal,
                        color = if(item.selected) Color.Black else Color.Gray

                    )
                },
                onClick = { onClick(i) },
                icon = {
                    Icon(
                        imageVector = if (item.selected) item.selectedIcon else item.icon,
                        contentDescription = null,
                        tint = if(item.selected) Color.Black else Color.Gray
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


