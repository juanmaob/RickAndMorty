package com.seventhson.rickandmorty.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.seventhson.rickandmorty.R

@Composable
fun MainScreen(viewModel: MainViewModel, onItemClick: (Int) -> Unit) {
    val toolbarHeightDp = 80.dp
    
    List(
        state = viewModel.characterListLiveData.observeAsState(),
        onBottomReached = { viewModel.getCharacterList() },
        paddingVertivalDp = toolbarHeightDp,
        onItemClick = onItemClick
    )

    Toolbar(
        height = toolbarHeightDp
    )
}

@Preview
@Composable
fun Toolbar(height: Dp = 120.dp) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
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