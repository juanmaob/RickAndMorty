package com.seventhson.rickandmorty.ui.common

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

    companion object {
        const val SHOW = true
        const val DISMISS = false
    }

    val loading = mutableStateOf(false)

    val errorMessage = mutableStateOf<Map<Int, String>?>(null)

}