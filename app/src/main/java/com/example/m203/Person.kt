package com.example.m203

data class Person(
    val nom : String,
    val prenom : String,
    val age : Int
)

val list = mutableListOf<Person>(
    Person("Doe", "John", 30),
    Person("Smith", "Jane", 25),
    Person("Brown", "Charlie", 40),
    Person("Johnson", "Emily", 22),
    Person("Davis", "Michael", 35)
)