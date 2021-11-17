package com.seventhson.rickandmorty.ui.detail

import android.os.Bundle
import androidx.activity.compose.setContent
import com.google.accompanist.pager.ExperimentalPagerApi
import com.seventhson.rickandmorty.ui.common.BaseComposeActivity
import com.seventhson.rickandmorty.ui.common.RMCompose
import com.seventhson.rickandmorty.utils.Navigator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : BaseComposeActivity() {

    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RMCompose {
                with(intent) {
                    DetailScreen(
                        id = getIntExtra(Navigator.CHARACTER_ID, -1),
                        name = getStringExtra(Navigator.NAME_ID) ?: "",
                        picture = getStringExtra(Navigator.PICTURE_ID) ?: ""
                    )
                }
            }
        }
    }

}

