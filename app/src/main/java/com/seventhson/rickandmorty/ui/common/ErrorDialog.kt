package com.seventhson.rickandmorty.ui.common

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color

@Composable
fun ErrorDialog(showDialog: MutableState<Boolean>) {

    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = {
                showDialog.value = false
            },
            text = {
                Text(
                    text = "Error",
                    color = Color.Black
                )
            },
            confirmButton = {
                TextButton(onClick = {
                    showDialog.value = false
                }) {
                    Text(text = "Cerrar")
                }
            },
            backgroundColor = Color.White
        )
    }
}