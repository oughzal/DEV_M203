package com.example.m03_compose

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

@Composable
fun ExempleAnimateContentSize() {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .background(Color.Gray)
            .padding(8.dp)
            .animateContentSize()   // 🔥 auto-animation
            .clickable { expanded = !expanded }
    ) {
        Text(
            text = if (expanded) "Texte très long..." else "Voir plus",
            modifier = Modifier.padding(16.dp)
        )
    }
}


@Composable
fun ExempleRotateModifier() {
    var rotated by remember { mutableStateOf(false) }

    val angle by animateFloatAsState(if (rotated) 360f else 0f)

    Icon(
        imageVector = Icons.Default.Refresh,
        contentDescription = null,
        modifier = Modifier
            .size(80.dp)
            .rotate(angle)
            .clickable { rotated = !rotated }
    )
}


@Composable
fun ExempleScaleModifier() {
    var pressed by remember { mutableStateOf(false) }

    val scale by animateFloatAsState(if (pressed) 0.7f else 1f)

    Box(
        Modifier
            .size(120.dp)
            .scale(scale)
            .background(Color.Blue)
            .clickable { pressed = !pressed }
    )
}

@Composable
fun ExempleOffsetModifier() {
    var moved by remember { mutableStateOf(false) }

    val offset by animateDpAsState(if (moved) 200.dp else 0.dp)

    Box(
        Modifier
            .offset(x = offset)
            .size(100.dp)
            .background(Color.Red)
            .clickable { moved = !moved }
    )
}

@Composable
fun ExempleAlphaModifier() {
    var show by remember { mutableStateOf(true) }

    val alpha by animateFloatAsState(if (show) 1f else 0f)

    Text(
        "Texte animé",
        modifier = Modifier
            .alpha(alpha)
            .clickable { show = !show }
    )
}

@Composable
fun ExempleGraphicsLayer() {
    var active by remember { mutableStateOf(false) }

    val scale by animateFloatAsState(if (active) 1.2f else 1f)
    val alpha by animateFloatAsState(if (active) 0.5f else 1f)
    val rotation by animateFloatAsState(if (active!!) 30f else 0f)

    Box(
        Modifier
            .size(120.dp)
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
                rotationZ = rotation
                this.alpha = alpha
            }
            .background(Color.Magenta)
            .clickable { active = !active }
    )
}



