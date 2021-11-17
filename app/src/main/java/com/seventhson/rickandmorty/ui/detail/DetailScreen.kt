package com.seventhson.rickandmorty.ui.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import com.seventhson.rickandmorty.ui.common.ErrorDialog

@Composable
fun DetailScreen(vm: DetailViewModel = hiltViewModel(), id: Int) {
    vm.getCharacterDetail(id)
    val showDialog = remember {
        mutableStateOf(false)
    }
    showDialog.value = vm.errorMessage.observeAsState().value != null
    ErrorDialog(showDialog)

    var isLoading = vm.loading.observeAsState()
    //ShowLoading(isLoading)
    DetailInfo(vm.characterDetailLiveData.observeAsState())
}