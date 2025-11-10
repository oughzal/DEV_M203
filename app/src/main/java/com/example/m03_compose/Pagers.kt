package com.example.m03_compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview


@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PHONE
)
@Composable
fun PagerScreen() {
    val pagerState = rememberPagerState(
        pageCount = { countries.size }
    )
    VerticalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize()
        ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) { pageIndex ->
        val item = countries[pageIndex]
        Image(
            painter = painterResource(item.imageId),
            contentDescription = null
        )
    }

}