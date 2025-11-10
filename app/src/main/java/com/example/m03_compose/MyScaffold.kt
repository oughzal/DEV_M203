package com.example.m03_compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PHONE
)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyScaffoldScreen() {
    var currentScreen by remember { mutableStateOf("Accueil") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Whatsapp") },
                actions = {
                    IconButton(onClick = { /* TODO: Handle search icon press */ }) {
                        Icon(Icons.Outlined.CameraAlt, contentDescription = "Search")
                    }
                    IconButton(onClick = { /* TODO: Handle search icon press */ }) {
                        Icon(Icons.Default.MoreVert, contentDescription = "Search")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { currentScreen = "Action !" }) {
                Icon(Icons.Default.Add, contentDescription = null)
            }
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = currentScreen == "Discussions",
                    onClick = { currentScreen = "Accueil" },
                    icon = { Icon(Icons.Filled.Email, contentDescription = "Discussions") },
                    label = { Text("Discussions") }
                )

                NavigationBarItem(
                    selected = currentScreen == "Paramètres",
                    onClick = { currentScreen = "Paramètres" },
                    icon = { Icon(Icons.Default.Newspaper, contentDescription = "Paramètres") },
                    label = { Text("Actus") }
                )
                NavigationBarItem(
                    selected = currentScreen == "Profil",
                    onClick = { currentScreen = "Profil" },
                    icon = { Icon(Icons.Default.Groups, contentDescription = "Profil") },
                    label = { Text("Communautés") }
                )
                NavigationBarItem(
                    selected = currentScreen == "Profil",
                    onClick = { currentScreen = "Profil" },
                    icon = { Icon(Icons.Default.Phone, contentDescription = "Profil") },
                    label = { Text("Appels") }
                )
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("DEVOAM", fontSize = 70.sp)
        }
    }
}
