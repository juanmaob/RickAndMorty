package com.seventhson.rickandmorty.ui.episode.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.seventhson.rickandmorty.ui.common.ErrorDialog
import com.seventhson.rickandmorty.ui.common.Loading
import com.seventhson.rickandmorty.ui.episode.EpisodeViewModel

@Composable
fun EpisodeScreen(
    viewModel: EpisodeViewModel = hiltViewModel(),
    id: Int,
    onClickBack: () -> Unit,
    onClickCharacter: (Int) -> Unit
) {
    viewModel.getEpisodeDetail(id)

    Box(Modifier.fillMaxSize().background(Color.White)) {
        
    }

    ErrorDialog(viewModel.errorMessage)
    Loading(isLoading = viewModel.loading)

}
