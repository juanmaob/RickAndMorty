package com.seventhson.rickandmorty.ui.main

import android.os.Bundle
import androidx.activity.compose.setContent
import com.seventhson.rickandmorty.ui.common.BaseComposeActivity
import com.seventhson.rickandmorty.ui.common.RMCompose
import com.seventhson.rickandmorty.ui.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseComposeActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RMCompose {
                Navigation()
            }
        }
    }

}