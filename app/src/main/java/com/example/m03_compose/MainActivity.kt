package com.example.m03_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDialog
import androidx.compose.material3.getSelectedDate
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.m03_compose.ui.theme.AppTheme
import java.nio.file.WatchEvent
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale


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

@OptIn(ExperimentalMaterial3Api::class)
@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PHONE
)
@Composable
fun MainScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        DatePickerField()
        TimePickerField()
        AlertDialogButton()
        DialogButton()
        ModalBottomSheetDialogButton()
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerField() {
    var openDialog by remember { mutableStateOf(false) }
    val dateState = rememberDatePickerState(LocalDate.now())


    Box(

        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
    ) {
        val selectedDate = dateState.getSelectedDate() ?: LocalDate.now()
        val value = "%02d/%02d/%04d %.2f %s".format(
            selectedDate.dayOfMonth,
            selectedDate.monthValue,
            selectedDate.year
        )
        val seletedDateFormated = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(selectedDate)
        OutlinedTextField(
            value = seletedDateFormated,
            readOnly = true,
            onValueChange = {},
            trailingIcon = {
                IconButton(onClick = { openDialog = !openDialog }) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = null
                    )
                }
            },
            modifier = Modifier.fillMaxWidth(),
            textStyle = TextStyle(textAlign = TextAlign.Center)
        )
        if (openDialog) {
            DatePickerDialog(
                onDismissRequest = { openDialog = false },
                confirmButton = {
                    TextButton(onClick = { openDialog = false }) {
                        Text("OK")
                    }
                }
            ) {
                DatePicker(state = dateState)
            }
        }
    }


}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePickerField() {
    val now = LocalTime.now()
    var state = rememberTimePickerState(initialHour = now.hour, initialMinute = now.minute, is24Hour = true)
    var openDialog by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
    ) {
        val value = "%02d:%02d".format(state.hour, state.minute)
        OutlinedTextField(
            value = value,
            onValueChange = {},
            trailingIcon = {
                IconButton(onClick = { openDialog = !openDialog }) {
                    Icon(
                        imageVector = Icons.Default.Timer,
                        contentDescription = null
                    )
                }
            },
            modifier = Modifier.fillMaxWidth(),
            textStyle = TextStyle(textAlign = TextAlign.Center)
        )
        if (openDialog) {
            TimePickerDialog(
                onDismissRequest = { openDialog = false },
                confirmButton = {
                    TextButton(onClick = { openDialog = false }) {
                        Text("OK")
                    }
                },
                title = { Text("Select time") }
            ) {
                TimePicker(
                    state = state
                )
            }

        }
    }
}

@Composable
fun AlertDialogButton(){
    var openDialog by remember { mutableStateOf(false) }

    Button(onClick = { openDialog = true }) {
        Text(text = "Show Alert Dialog")
    }
    if (openDialog) {
        AlertDialog(
            onDismissRequest = { openDialog = false },
            title = { Text("Confirmation") },
            icon = {Icon(imageVector = Icons.Default.Info, contentDescription = null)},
            text = { Text("Voulez-vous continuer ?") },
            confirmButton = {
                TextButton(onClick = { openDialog = false }) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { openDialog = false }) {
                    Text("Annuler")
                }
            }
        )
    }
}

@Composable
fun DialogButton(){
    var openDialog by remember { mutableStateOf(false) }

    Button(onClick = { openDialog = true }) {
        Text(text = "Show Dialog")
    }
    if (openDialog) {
        Dialog(
            onDismissRequest = { openDialog = false }
        ){
            Box(
                modifier = Modifier.background(Color.White, RoundedCornerShape(16.dp)).padding(20.dp)
            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Dialog")
                    Button(onClick = {openDialog = false}) {
                        Text("Fermer")
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalBottomSheetDialogButton(){
    var openSheet by remember { mutableStateOf(false) }
    Button(onClick = {openSheet = true}) {
        Text("show Buttom sheet")
    }
    if(openSheet){
        ModalBottomSheet(
            onDismissRequest = { openSheet = false },
            sheetGesturesEnabled = true
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                contentAlignment = Alignment.Center
            ) {
                Text("This is a modal bottom sheet")
            }
        }
    }
}







