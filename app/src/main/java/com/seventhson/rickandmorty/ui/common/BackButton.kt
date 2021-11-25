package com.seventhson.rickandmorty.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.seventhson.rickandmorty.R

@Composable
fun BackButton(modifier: Modifier, onClick: () -> Unit) {
    Image(
        painter = painterResource(id = R.drawable.ic_arrow_back),
        contentDescription = null,
        colorFilter = ColorFilter.tint(color = Color.Black),
        modifier = modifier
            .size(66.dp)
            .padding(16.dp)
            .background(shape = CircleShape, color = Color.White)
            .padding(4.dp)
            .clip(shape = CircleShape)
            .clickable { onClick() }
    )
}