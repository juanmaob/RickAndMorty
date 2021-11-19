package com.seventhson.rickandmorty.ui.main

import android.os.Bundle
import androidx.activity.compose.setContent
import com.seventhson.rickandmorty.ui.common.BaseComposeActivity
import com.seventhson.rickandmorty.ui.common.RMCompose
import com.seventhson.rickandmorty.ui.main.views.MainScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseComposeActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RMCompose {
                MainScreen() {
                    navigator.goToDetail(this, it.id, it.name, it.image, null)
                }
            }
        }
    }

}