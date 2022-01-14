package com.seventhson.rickandmorty.ui.main.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.seventhson.rickandmorty.domain.model.Character
import com.seventhson.rickandmorty.ui.common.ErrorDialog
import com.seventhson.rickandmorty.ui.common.Loading
import com.seventhson.rickandmorty.ui.main.MainViewModel
import com.seventhson.rickandmorty.utils.isScrolledToTheEnd

@Composable
fun ListCharacters(
    viewModel: MainViewModel = hiltViewModel(),
    onItemClick: (Character) -> Unit
) {
    val scrollState = rememberLazyListState()
    val state = viewModel.characterListState

    LazyColumn(
        state = scrollState,
        modifier = Modifier.fillMaxSize()
    ) {

        // Character items
        items(state) { character ->
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

    val loadMore by remember {
        derivedStateOf {
            scrollState.isScrolledToTheEnd()
        }
    }

    //entra dentro del launchedeffect cada vez que loadMore cambia
    // y luego solo si es true, llama al viewmodel
    LaunchedEffect(loadMore) {
        if (loadMore)
            viewModel.getCharacterList()
    }

    ErrorDialog(viewModel.errorMessage)
    Loading(isLoading = viewModel.loading)

}