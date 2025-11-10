package com.example.m03_compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random


data class Item(val text : String,val width: Dp, val color: Color, val aspectRatio: Float)

val items = (1..100).map {
    Item(
        width = Random.nextInt(100, 300).dp,
        aspectRatio = Random.nextDouble(0.5, 1.3).toFloat(),
        color = Color(
            red = Random.nextFloat(),
            green = Random.nextFloat(),
            blue = Random.nextFloat(),
            alpha = 1f
        ),
        text = "$it"
    )
}

@Composable
fun ItemScreen(item: Item) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start=16.dp, end=16.dp)
            .height(80.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(item.color)
    ) {
        Text(
            text = item.text, fontSize = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .width(50.dp)
                .aspectRatio(1f)
                .clip(CircleShape)
                .background(Color.White)
                .wrapContentHeight(align = Alignment.CenterVertically)
        )
    }
}