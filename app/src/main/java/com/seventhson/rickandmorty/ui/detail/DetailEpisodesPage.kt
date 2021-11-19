package com.seventhson.rickandmorty.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.seventhson.rickandmorty.ui.ui.theme.VeryLightGrey

@Preview
@Composable
fun DetailEpisodesPage(
    episodes: List<String> = listOf("1", "2")
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(episodes) { episode ->

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                "Episode ${episode.substringAfterLast("/")}",
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
            )
        }
        item { Spacer(Modifier.height(16.dp))}
    }
}