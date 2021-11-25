package com.seventhson.rickandmorty.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.seventhson.rickandmorty.ui.ui.theme.Typography
import com.seventhson.rickandmorty.ui.ui.theme.VeryLightGrey

@Preview
@Composable
fun KeyValueInfo(title: String = "Status", data: String = "Status") {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(
                shape = RoundedCornerShape(corner = CornerSize(8.dp)),
                color = VeryLightGrey
            )
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {

        Text(
            text = title,
            color = Color.Black,
            style = Typography.h5,
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = data,
            color = Color.Gray,
            style = Typography.body1,
        )
    }
}