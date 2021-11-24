package com.seventhson.rickandmorty.ui.episode.views

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.seventhson.rickandmorty.ui.common.ErrorDialog
import com.seventhson.rickandmorty.ui.detail.TabItem
import com.seventhson.rickandmorty.ui.episode.EpisodeViewModel

@ExperimentalPagerApi
@Composable
fun EpisodeScreen(
    viewModel: EpisodeViewModel = hiltViewModel(),
    id: Int,
    onClickBack: () -> Unit,
    onClickCharacter: (Int) -> Unit
) {
    //viewModel.getEpisode(id)

    val tabList = listOf(
        TabItem.Info,
        TabItem.Episodes
    )

    val showDialog = remember { mutableStateOf(false) }
    showDialog.value = viewModel.errorMessage.observeAsState().value != null

    ErrorDialog(showDialog)

    Column {
        //DetailHeader(name, picture, onClickBack)
        //DetailInfo(viewModel.characterDetailLiveData.observeAsState(), tabList, onClickEpisode)
    }

}
