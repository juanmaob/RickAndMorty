package com.seventhson.rickandmorty.ui.episode.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.seventhson.rickandmorty.ui.episode.EpisodeViewModel

@Composable
fun EpisodeScreen(
    viewModel: EpisodeViewModel = hiltViewModel(),
    id: Int,
    onClickBack: () -> Unit,
    onClickCharacter: (Int) -> Unit
) {
    Box(Modifier.fillMaxSize().background(Color.White)) {
        
    }
    /*viewModel.getEpisode(id)

    val showDialog = remember { mutableStateOf(false) }
    showDialog.value = viewModel.errorMessage.value != null

    ErrorDialog(showDialog)

    Column {
        //DetailHeader(name, picture, onClickBack)
        //DetailInfo(viewModel.characterDetailLiveData.observeAsState(), tabList, onClickEpisode)
    }
*/
}
