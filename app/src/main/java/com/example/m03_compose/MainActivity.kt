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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Dangerous
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
            ) {
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
    AlertDialogSceen()
    DialogScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialogSceen() {
    var showDialog by remember { mutableStateOf(false) }
    Button(
        onClick = { showDialog = true }
    ) { Text("Alert") }
    if (showDialog) {
        AlertDialog(
            icon = {
                Icon(
                    imageVector = Icons.Default.Dangerous, contentDescription = null,
                    modifier = Modifier.size(200.dp)
                )
            },
            onDismissRequest = { showDialog = false },
            title = { Text("Alert Title") },
            text = { Text("This is a simple alert dialog message.") },
            confirmButton = {
                TextButton(onClick = {
                    // Handle confirm action
                    showDialog = false
                }) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    // Handle dismiss action
                    showDialog = false
                }) {
                    Text("Dismiss")
                }
            }
        )
    }
}

@Composable
fun DialogScreen() {
    var screen by remember { mutableStateOf("message") }
    var showDialog by remember { mutableStateOf(false) }
    Button(
        onClick = { showDialog = true }
    ) { Text("Dialog") }
    if (showDialog) {
        Dialog(
            onDismissRequest = { showDialog = false }
        ) {
            when(screen){
                "message" -> MessageScreen{ showDialog = it }
                else -> { /* No-op */}
            }
        }
    }
}

@Composable
fun MessageScreen(callback : (Boolean) -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(Color.White, shape = RoundedCornerShape(16.dp))
            .padding(20.dp)
    ) {
        Text("This is a simple dialog message.")
        Button(
            onClick = { callback(false) }
        ) {
            Text("Close")
        }
    }
}


