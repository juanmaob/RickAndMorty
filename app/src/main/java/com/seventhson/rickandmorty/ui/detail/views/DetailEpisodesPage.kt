package com.seventhson.rickandmorty.ui.detail.views
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.seventhson.rickandmorty.ui.common.SimpleListItem
import com.seventhson.rickandmorty.ui.ui.theme.VeryLightGrey

@Composable
fun DetailEpisodesPage(
    episodes: List<String> = listOf("1", "2"),
    onClickEpisode: (Int) -> Unit
) {
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
    ) {
        items(episodes) { episode ->
            val episodeId = episode.substringAfterLast("/")
            SimpleListItem("Episode", episodeId, onClickEpisode)
        }

        item { Spacer(Modifier.height(16.dp))}
    }
}

@Preview
@Composable
fun DetailEpisodesPagePreview() {
    DetailEpisodesPage(episodes = listOf("1", "3"), onClickEpisode = {})
}