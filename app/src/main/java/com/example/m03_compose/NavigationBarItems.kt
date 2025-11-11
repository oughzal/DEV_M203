package com.example.m03_compose

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Groups
import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem(
    val title: String,
    val icon: ImageVector,
    val selectedIcon : ImageVector ,
    val selected : Boolean = false,
)


val navigationBarItems = listOf(
    NavigationItem(title = "Chats", icon = Icons.Outlined.Email, selectedIcon = Icons.Filled.Email, selected = true),
    NavigationItem(title = "Status", icon = Icons.Outlined.Groups, selectedIcon = Icons.Filled.Groups),
    NavigationItem(title = "Camera", icon = Icons.Outlined.CameraAlt, selectedIcon = Icons.Filled.CameraAlt)
)
