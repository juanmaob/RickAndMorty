package com.seventhson.rickandmorty.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PillText(
    text: String,
    textColor: Color = Color.White,
    backgroundColor: Color = Color.Gray
) {
    Text(
        text = text,
        color = textColor,
        fontSize = 10.sp,
        modifier = Modifier
            .background(
                shape = RoundedCornerShape(corner = CornerSize(16.dp)),
                color = backgroundColor
            )
            .padding(start = 8.dp, top = 1.dp, end = 8.dp, bottom = 2.dp)

    )
}