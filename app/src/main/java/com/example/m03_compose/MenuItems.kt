package com.example.m03_compose

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Groups
import androidx.compose.ui.graphics.vector.ImageVector

data class MainMenuItem(
    val title: String,
    val icon: ImageVector
)

val mainMenuItems = listOf(
    MainMenuItem(title = "New Group", icon = Icons.Outlined.Groups),
    MainMenuItem(title = "New Message", icon = Icons.Outlined.Email),
    MainMenuItem(title = "New Camera", icon = Icons.Outlined.CameraAlt)

)