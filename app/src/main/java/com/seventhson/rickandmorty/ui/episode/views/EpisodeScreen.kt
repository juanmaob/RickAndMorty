package com.seventhson.rickandmorty.ui.episode.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.seventhson.rickandmorty.domain.model.Episode
import com.seventhson.rickandmorty.ui.common.ErrorDialog
import com.seventhson.rickandmorty.ui.common.KeyValueInfo
import com.seventhson.rickandmorty.ui.common.Loading
import com.seventhson.rickandmorty.ui.common.SimpleListItem
import com.seventhson.rickandmorty.ui.episode.EpisodeViewModel

@Composable
fun EpisodeScreen(
    viewModel: EpisodeViewModel = hiltViewModel(),
    id: Int,
    onClickBack: () -> Unit,
    onClickCharacter: (Int) -> Unit
) {

    LaunchedEffect(Unit) {
        viewModel.getEpisodeDetail(id)
    }

    EpisodeDetail(viewModel.episodeDetailState, onClickCharacter)

    ErrorDialog(viewModel.errorMessage)
    Loading(isLoading = viewModel.loading)
}

@Composable
fun EpisodeDetail(
    state: State<Episode>,
    onClickCharacter: (Int) -> Unit
) = state.value.let { episode ->

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)) {
        KeyValueInfo("Name", episode.name)
        KeyValueInfo("Episode", episode.episode)
        KeyValueInfo("Air date", episode.air_date)

        LazyColumn {
            items(episode.characters) { characterUrl ->
                val characterId = characterUrl.substringAfterLast("/")
                SimpleListItem("Character", characterId, onClickCharacter)
            }
        }
    }
}

@Composable
fun EpisodeDetailUI(
    episode: Episode,
    onClick: (Int) -> Unit
) {

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)) {
        KeyValueInfo("Name", episode.name)
        KeyValueInfo("Episode", episode.episode)
        KeyValueInfo("Air date", episode.air_date)

        LazyColumn {
            items(episode.characters) { characterUrl ->
                val characterId = characterUrl.substringAfterLast("/")

                SimpleListItem("Character", characterId, onClick)
            }
        }
    }
}

@Preview
@Composable
fun EpisodeDetailUIPreview() {
    EpisodeDetailUI(episode = Episode(characters = listOf("Uno/1", "Dos/2")), onClick = {})
}
