package com.seventhson.rickandmorty.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.seventhson.rickandmorty.ui.common.ErrorDialog

@ExperimentalPagerApi
@Composable
fun DetailScreen(
    vm: DetailViewModel = hiltViewModel(),
    id: Int,
    name: String,
    picture: String
) {
    vm.getCharacterDetail(id)

    val showDialog = remember { mutableStateOf(false) }
    showDialog.value = vm.errorMessage.observeAsState().value != null

    ErrorDialog(showDialog)

    Column {
        DetailHeader(name, picture)
        DetailInfo(vm.characterDetailLiveData.observeAsState())
    }
}