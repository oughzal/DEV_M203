package com.example.m03_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.More
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Button
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


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
        topBar = { TopBarScreen() },
        bottomBar = { BottomBarScreen() }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            Text(text = "${coutryFlag("MA")}",
                fontSize = 80.sp
            )
        }

    }

}

@Composable
fun BottomBarScreen() {
    NavigationBar {
        NavigationBarItem(
            label = { Text(text = "Home") },
            selected = true,
            onClick = { },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = null
                )
            }
        )
        NavigationBarItem(
            label = { Text(text = "Profil") },
            selected = false,
            onClick = { },
            icon = {
                Icon(
                    imageVector = Icons.Outlined.Person,
                    contentDescription = null
                )
            }
        )
        NavigationBarItem(
            label = { Text(text = "Profil") },
            selected = false,
            onClick = { },
            icon = {
                Icon(
                    imageVector = Icons.Outlined.Person,
                    contentDescription = null
                )
            }
        )
        NavigationBarItem(
            label = { Text(text = "Setting") },
            selected = false,
            onClick = { },
            icon = {
                Icon(
                    imageVector = Icons.Outlined.Settings,
                    contentDescription = null
                )
            }
        )

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarScreen() {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Outlined.Home,
                    contentDescription = null
                )
            }
        },
        title = { Text(text = "Whatsapp") },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Outlined.CameraAlt,
                    contentDescription = null
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = null
                )
            }
        },

        modifier = Modifier
            .background(Color.Cyan)
    )
}


