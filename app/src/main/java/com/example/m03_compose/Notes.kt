package com.example.m03_compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

data class Note(
    var title: String,
    val content: String,
    val color : Long = 0xFFFFFFFF
)
val notes = mutableListOf<Note>(
    Note(
        title = "First Note",
        content = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Velit nam inventore dolorem fugit dicta cupiditate numquam amet rerum, asperiores odio quia, necessitatibus perferendis, at sunt nisi aut ratione architecto natus.",
        color = 0xFFFFCDD2
    ),
    Note(
        title = "Second Note",
        content = "This is the content of the second note.",
        color = 0xFFC8E6C9
    ),
    Note(
        title = "Third Note",
        content = "This is the content of the third note.",
        color = 0xFFBBDEFB
    )
)

@Composable
fun NoteListScreen(navController: NavController){
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(6.dp),
        modifier = Modifier.fillMaxSize().padding(vertical = 80.dp, horizontal = 6.dp)
    ) {
        itemsIndexed(notes){i , note ->
            NoteCard(navController,note = note, index = i)
        }
    }
}

@Composable
fun NoteCard(navController: NavController,note: Note, index: Int) {
    OutlinedCard(
        elevation = CardDefaults.outlinedCardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.outlinedCardColors().copy(
            containerColor = Color(note.color)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .clickable{
                navController.navigate(NoteRoute(index))
            }
    ){
        Column(modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()) {
            Text(
                text=note.title,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                )
            Text(
                text=note.content,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
                )
        }
    }
}

@Serializable
object NotesListRoute

@Serializable
data class NoteRoute(val index: Int)

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NotesListRoute
    ){
        composable<NotesListRoute>{
            NoteListScreen(navController)
        }
        composable<NoteRoute> {
            val note : NoteRoute = it.toRoute()
            NoteScreen(navController,note.index)
        }
    }
}

@Composable
fun NoteScreen(navController: NavController,index : Int) {
    val note : Note = notes[index].copy(
        title = "DEVOAM"
    )
    note.title = "DEVOAM"
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(note.color))
            .padding(16.dp)
    ) {
        Text(
            text = note.title,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = note.content,
            fontSize = 16.sp
        )
        Button(onClick = {
            notes[index] = note
            navController.popBackStack()
        }) { Text("Save") }
    }
}