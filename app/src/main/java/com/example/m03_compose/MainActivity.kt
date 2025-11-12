package com.example.m03_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Key
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme{
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
    val textStyle = TextStyle(
        color = Color.Green,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    )
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
Column(
    verticalArrangement = Arrangement.spacedBy(10.dp),
    modifier = Modifier
        .padding(top=80.dp, start = 10.dp, end = 10.dp)

) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "Logo Image",
            modifier = Modifier
                .width(150.dp)
                 .clip(CircleShape)
                .background(Color.Red)
                .then(
                    if(1==2) Modifier.border(
                        BorderStroke(4.dp, Color.Green),
                        shape = CircleShape
                    ) else Modifier
                )

        )
        Column {
            OutlinedTextField(
                value = email,
                placeholder = {Text("Email")},
                label = {Text("Email")},
                leadingIcon = {Icon(imageVector = Icons.Default.Email, contentDescription = "Email Icon")},
                onValueChange = { if(it.isDigitsOnly()) email = it},
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.NumberPassword,
                    imeAction = ImeAction.Next
                )
            )
            OutlinedTextField(
                value = password,
                label = {Text("Password")},
                leadingIcon = {Icon(imageVector = Icons.Default.Key, contentDescription = "Email Icon")},
                onValueChange = {password = it},
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.NumberPassword,
                    imeAction = ImeAction.Done
                ),
                visualTransformation = PasswordVisualTransformation(mask = '\u263A'),
                keyboardActions = KeyboardActions(
                    onDone = {},
                    onSearch = {}
                )
            )

        }
    }
    Button(
        onClick = {},
        modifier = Modifier
            .align(Alignment.CenterHorizontally)
    ) {
        Text(text = "Se connecter")
    }
}

}


