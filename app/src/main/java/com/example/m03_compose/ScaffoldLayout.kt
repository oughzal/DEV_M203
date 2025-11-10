package com.example.m03_compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BoxScreen(text: String, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .then(modifier)
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .wrapContentHeight(align = Alignment.CenterVertically)

        )
    }

}


@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PHONE
)
@Composable
fun ScaffoldScreen() {
    Scaffold(
        topBar = {
            BoxScreen(
                "Top Bar", Modifier
                    .background(Color.Blue)
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(16.dp)
            )
        },
        bottomBar = {
            BoxScreen(
                "Bottom Bar", Modifier
                    .background(Color.Red)
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(16.dp)
            )
        },
        floatingActionButton = {
            BoxScreen(
                "FAB",
                Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .background(Color.Black)
            )
        }
    ) {
        BoxScreen(
            "Content",
            Modifier
                .padding(it)
                .fillMaxSize()
                .background(Color.DarkGray)
        )
    }
}