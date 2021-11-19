package com.seventhson.rickandmorty.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.seventhson.rickandmorty.R

@Composable
fun MainScreen(onItemClick: (Int) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.height(80.dp),
                elevation = 16.dp,
                backgroundColor = Color.White,
                content = {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Image(
                            painter = rememberImagePainter(data = R.drawable.rickmortylogo),
                            contentDescription = null,
                            modifier = Modifier.padding(16.dp)
                        )
                    }

                }
            )
        }
    ) {
        ListCharacters(onItemClick = onItemClick)
    }

}

@Preview
@Composable
fun Toolbar() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .alpha(0.8f)
            .padding(bottom = 8.dp)
            .graphicsLayer {
                shadowElevation = 28f
                shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)
                clip = true
            }
            .background(color = Color.White)
            .padding(4.dp)

    ) {
        Image(
            painter = rememberImagePainter(data = R.drawable.rickmortylogo),
            contentDescription = null,
            modifier = Modifier.fillMaxHeight(0.8f)
        )
    }
}