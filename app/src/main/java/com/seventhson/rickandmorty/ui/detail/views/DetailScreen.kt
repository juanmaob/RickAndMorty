package com.seventhson.rickandmorty.ui.detail.views

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.seventhson.rickandmorty.ui.common.ErrorDialog
import com.seventhson.rickandmorty.ui.common.Loading
import com.seventhson.rickandmorty.ui.detail.DetailViewModel
import com.seventhson.rickandmorty.ui.detail.TabItem

@ExperimentalPagerApi
@Composable
fun DetailScreen(
    viewModel: DetailViewModel = hiltViewModel(),
    id: Int,
    name: String,
    picture: String,
    onClickBack: () -> Unit,
    onClickEpisode: (Int) -> Unit
) {

    //Se usa para lanzar solo una vez a lo del bloque. Se puede volver a lanzar si "key1" cambia.
    //En este caso no lo cambiamos y nos aseguramos que solo se llama a la getChacarterDetail una sola vez.
    LaunchedEffect(Unit) {
        viewModel.getCharacterDetail(id)
    }

    val tabList = listOf(
        TabItem.Info,
        TabItem.Episodes
    )
    Column {
        DetailHeader(name, picture, onClickBack)
        DetailInfo(viewModel.characterDetailState, tabList, onClickEpisode)
    }

    ErrorDialog(viewModel.errorMessage)
    Loading(isLoading = viewModel.loading)

}
