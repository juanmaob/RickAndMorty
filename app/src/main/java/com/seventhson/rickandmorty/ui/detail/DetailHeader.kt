package com.seventhson.rickandmorty.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.transform.RoundedCornersTransformation
import com.seventhson.rickandmorty.ui.ui.theme.Black70

@Composable
fun DetailHeader(name: String, picture: String) {
    val headerHeight = 300.dp

    Box(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
        .height(headerHeight)
    ) {
        Image(
            painter = rememberImagePainter(picture) {
                transformations(RoundedCornersTransformation(20f))
                crossfade(true)
            },
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(headerHeight.div(3))
                .background(brush = Brush.verticalGradient(colors = listOf(Color.Transparent, Black70)))
        ) {
            Text(
                text = name,
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
            )
        }

    }

}