package com.seventhson.rickandmorty.ui.main.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.seventhson.rickandmorty.domain.model.Character
import com.seventhson.rickandmorty.ui.main.MainViewModel
import com.seventhson.rickandmorty.utils.isScrolledToTheEnd

@Composable
fun ListCharacters(
    viewModel: MainViewModel = hiltViewModel(),
    onItemClick: (Character) -> Unit
) {
    val scrollState = rememberLazyListState()
    val state = viewModel.characterListLiveData.observeAsState()

    LazyColumn (
        state = scrollState,
        modifier = Modifier.fillMaxSize()
    ) {
        state.value?.let {

            // Character items
            items(it) { character ->
                Item(character, onItemClick)
                Spacer(modifier = Modifier.height(8.dp))
            }

            // Loading more item
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(modifier = Modifier.size(32.dp))
                }
            }
        }
    }

    if (scrollState.isScrolledToTheEnd()) {
        viewModel.getCharacterList()
    }
}