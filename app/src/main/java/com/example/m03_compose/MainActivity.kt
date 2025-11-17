package com.example.m03_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme{
                NavScreen() // homme , screen1, screen2
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
fun NavScreen() {
    val navController = rememberNavController()

    NavHost (
        navController = navController,
        startDestination = "home/0"
    ){
        composable(
            route ="home/{id}",
            arguments = listOf(
                navArgument("id"){
                    defaultValue = "0"
                    nullable = true
                    type = NavType.StringType
                }
            )
        ){
            val id : String = it.arguments?.getString("id") ?: "0"
            HomeScreen(navController,id=id )
        }
        composable("screen1"){
            Screen1(navController)
        }
        composable("screen2"){
            Screen2(navController)
        }

    }

}


@Composable
fun HomeScreen(navController: NavController, id: String?) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Acceuil Screen  ID: $id",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )
        Button(onClick ={
            navController.popBackStack()
            navController.navigate("screen1")

        } ) {
            Text("To Screen 1")
        }
    }
}
@Composable
fun Screen1(navController: NavController) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ){
        Text(
            text = "Screen1",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )
        Button(onClick ={
            navController.navigate("screen2")
        } ) {
            Text("To Screen 2")
        }
    }
}
@Composable
fun Screen2(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Screen 2",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )
        Button(onClick ={
            navController.navigate("home/1234")
        } ) {
            Text("To Home")
        }
    }
}



