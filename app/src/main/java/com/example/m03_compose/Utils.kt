package com.example.m03_compose

fun coutryFlag(countryCode: String): String {
    val firstLetter = countryCode[0].code + 127397
    val secondLetter = countryCode[1].code + 127397
    return String(Character.toChars(firstLetter)) + String(Character.toChars(secondLetter))
}