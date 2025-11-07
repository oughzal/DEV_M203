package com.example.m03_compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PHONE
)
@Composable
fun TheModifierPreview() {
    Box(
        modifier = Modifier
            .padding(20.dp)
            .size(350.dp, 350.dp)
            .clip(CircleShape)
            .background(Color.Green)
            .padding(20.dp)
            .clip(CircleShape)
            .background(Color.Red)
            .padding(20.dp)
            .clip(CircleShape)
            .background(Color.Yellow)
            .padding(20.dp)
            .clip(CircleShape)
            .background(Color.Red)
            .padding(20.dp)
            .clip(CircleShape)
            .background(Color.Yellow)
            .padding(20.dp)
            .clip(CircleShape)
            .background(Color.Red)
            .padding(20.dp)
            .clip(CircleShape)
            .background(Color.Black)
            .clickable(onClick = {})
    ){}
}