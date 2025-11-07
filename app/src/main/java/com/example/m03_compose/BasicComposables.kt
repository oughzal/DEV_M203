package com.example.m03_compose

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
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


// Exemple – Bouton (Button)
// Button() : Permet de créer un bouton cliquable avec une action associée.
@Composable
fun ExempleButton() {
    Button(onClick = { Log.d("Compose", "Bouton cliqué !") }) {
        Text("Cliquez ici")
    }
}

// Exemple – Image (Image)
// Image() : Permet d'afficher une image à l'écran.
// painter : peut prendre différentes sources d'images, comme des ressources locales ou des images réseau. (painterResource,painterBitmap,)
@Composable
fun ExempleImage() {
    Image(
        painter = painterResource(R.drawable.ic_launcher_background),
        contentDescription = "Photo de profil",
        modifier = Modifier.size(100.dp)
    )
}

// Exemple – CheckBox
// Checkbox() : Permet à l'utilisateur de sélectionner ou désélectionner une option.
@Composable
fun ExempleCheckBox() {
    var checked by remember { mutableStateOf(false) }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = checked, onCheckedChange = { checked = it })
        Text(if (checked) "Activé" else "Désactivé")
    }
}

// Exemple – RadioButton
// RadioButton() : Permet à l'utilisateur de sélectionner une option parmi un groupe d'options.
@Composable
fun ExempleRadioGroup() {
    var choix by remember { mutableStateOf("Option 1") }

    Column {
        listOf("Option 1", "Option 2", "Option 3").forEach {
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = (it == choix),
                    onClick = { choix = it }
                )
                Text(it)
            }
        }
    }
}

// Exemple – Switch
// Switch() : Permet à l'utilisateur d'activer ou de désactiver une option.
@Composable
fun ExempleSwitch() {
    var actif by remember { mutableStateOf(false) }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Switch(checked = actif, onCheckedChange = { actif = it })
        Text(if (actif) "Mode actif" else "Mode inactif")
    }
}

// Exemple – Slider
// Slider() : Permet à l'utilisateur de sélectionner une valeur dans une plage définie en faisant glisser un curseur.
@Composable
fun ExempleSlider() {
    var volume by remember { mutableStateOf(0.5f) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Slider(value = volume, onValueChange = { volume = it })
        Text("Volume : ${(volume * 100).toInt()}%")
    }
}

// Exemple - IconButton
// IconButton() : Permet de créer un bouton avec une icône cliquable.
// gradle : implementation ("androidx.compose.material:material-icons-extended:1.7.8")
@Composable
fun ExempleIconButton() {
    IconButton(
        onClick = { Log.d("Compose", "IconButton cliqué !") }
    ) {
        Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = "Icône de bouton"
        )
    }
}










