package com.seventhson.rickandmorty.ui.detail

import android.os.Bundle
import androidx.activity.compose.setContent
import com.seventhson.rickandmorty.ui.common.BaseComposeActivity
import com.seventhson.rickandmorty.ui.common.RMCompose
import com.seventhson.rickandmorty.utils.Navigator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : BaseComposeActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RMCompose {
                DetailScreen(id = intent.getIntExtra(Navigator.CHARACTER_ID, -1))
            }
        }
    }

}

