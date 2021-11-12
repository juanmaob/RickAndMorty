package com.seventhson.rickandmorty.ui.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState

@Composable
fun MainScreen(viewModel: MainViewModel, onItemClick: (Int) -> Unit) {
    List(
        state = viewModel.characterListLiveData.observeAsState(),
        onBottomReached = { viewModel.getCharacterList() },
        onItemClick = onItemClick
    )
}