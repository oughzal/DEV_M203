package com.example.m03_compose

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Affichage de texte
// Text() : Permet d'afficher du texte à l'écran avec diverses options de personnalisation.
@Composable
fun ExempleText() {
    Text(
        text = "Bonjour Jetpack Compose 👋",
        color = Color.Blue,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    )
}

// Champ de saisie (TextField)
// TextField() : Permet à l'utilisateur de saisir du texte.
@Composable
fun ExempleTextField() {
    var name by remember { mutableStateOf("") }

    TextField(
        value = name,
        onValueChange = { name = it },
        label = { Text("Entrez votre nom") }
    )
}







