package com.example.m203

import kotlin.coroutines.Continuation

data class Conversation(
        val name : String,
        val hour : String,
        val lastMessage : String,
        val profileImage : Int,
        val isOnline : Boolean = false
        )
val conversations = mutableListOf<Conversation>(
        Conversation("Alice", "10:30 AM", "Hey, how are you?", R.drawable.profile1),
        Conversation("Bob", "9:15 AM", "Don't forget the meeting tomorrow.", R.drawable.profile2,true),
        Conversation("Charlie", "Yesterday", "Check out this cool photo!", R.drawable.profile3),
        Conversation("Diana", "Monday", "Can we reschedule our appointment?", R.drawable.profile4,true),
        Conversation("Eve", "Sunday", "Happy Birthday!", R.drawable.profile5),
        Conversation("Frank", "Saturday", "Let's catch up soon.", R.drawable.profile1,true),
        Conversation("Grace", "Friday", "I sent you the documents.", R.drawable.profile3),
        Conversation("Hank", "Thursday", "See you at the game!", R.drawable.profile1,true),
        Conversation("Ivy", "Wednesday", "Thanks for your help!", R.drawable.profile2),
        Conversation("Jack", "Tuesday", "Looking forward to our trip.", R.drawable.profile4,true)

)