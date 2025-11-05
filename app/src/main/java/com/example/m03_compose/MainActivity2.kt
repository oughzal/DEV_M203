package com.example.m03_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.m03_compose.ui.theme.M03_composeTheme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Column {
                FirstSreen()
            }

        }
    }
}



@Preview(showBackground = true)
@Composable
fun FirstSreen(){

    var nom by remember {
        mutableStateOf("")
    }

    //TextView
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()

    ) {
        Text(
            text = "Nom : $nom",
            fontSize= 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Red
        )
        OutlinedTextField(
            value = nom,
            onValueChange = {nom = it},
            label = { Text(text = "Escribe tu nombre") }

        )
        Button(
            onClick = {nom = "2025"}
        ) {
            Text("Cliquer ici")
        }
        DicesScreen()
    }
}

@Composable
fun DicesScreen(){
    val dices = listOf(R.drawable.dice1,
        R.drawable.dice2,
        R.drawable.dice3,
        R.drawable.dice4,
        R.drawable.dice5,
        R.drawable.dice6)
    var i by rememberSaveable {
        mutableStateOf(0)
    }
    Spacer(modifier = Modifier.height(20.dp))
    Image(
        painter = painterResource(dices[i]),
        contentDescription = null
    )

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        Button(
            onClick = {
                i = if(i==0) 5 else i-1
            }
        ) {
            Text("Prev")
        }
        Spacer(modifier = Modifier.width(20.dp))
        Button(
            onClick = {
                i = (i+1)%6
            }
        ) {
            Text("Next")
        }
    }
}