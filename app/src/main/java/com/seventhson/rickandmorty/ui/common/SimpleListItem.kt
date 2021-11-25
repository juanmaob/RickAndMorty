package com.seventhson.rickandmorty.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.seventhson.rickandmorty.ui.ui.theme.VeryLightGrey


@Composable
fun SimpleListItem(typeText: String, itemId: String, onClick: (Int) -> Unit) {
    Spacer(modifier = Modifier.height(16.dp))
    Text(
        text = "$typeText $itemId",
        maxLines = 1,
        textAlign = TextAlign.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .background(
                shape = RoundedCornerShape(corner = CornerSize(8.dp)),
                color = VeryLightGrey
            )
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable {
                onClick(itemId.toIntOrNull() ?: 1)
            }
    )
}