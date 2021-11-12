package com.seventhson.rickandmorty.ui.common

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State

@Composable
fun Loading(isLoading: State<Boolean>) {
    if (isLoading.value)
        CircularProgressIndicator()
}