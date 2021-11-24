package com.seventhson.rickandmorty.ui.common

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.seventhson.rickandmorty.ui.ui.theme.RickAndMortyTheme

@Composable
fun RMCompose(
    content: @Composable () -> Unit
) {
    RickAndMortyTheme {
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}