package com.seventhson.rickandmorty.ui.common

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color

@Composable
fun ErrorDialog(state: MutableState<Map<Int, String>?>) {
    val showDialog = remember { mutableStateOf(false) }
    showDialog.value = state.value != null

    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = {
                state.value = null
            },
            text = {
                Text(
                    text = state.value?.values?.first() ?: "",
                    color = Color.Black
                )
            },
            confirmButton = {
                TextButton(onClick = {
                    state.value = null
                }) {
                    Text(text = "Cerrar")
                }
            },
            backgroundColor = Color.White
        )
    }
}