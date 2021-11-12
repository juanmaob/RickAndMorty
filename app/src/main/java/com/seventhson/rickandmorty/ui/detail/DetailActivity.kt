package com.seventhson.rickandmorty.ui.detail

import android.os.Bundle
import androidx.activity.compose.setContent
import com.seventhson.rickandmorty.ui.common.BaseComposeActivity
import com.seventhson.rickandmorty.ui.common.RMCompose
import com.seventhson.rickandmorty.utils.Navigator
import com.seventhson.rickandmorty.utils.ViewModelFactory
import dagger.android.AndroidInjection
import javax.inject.Inject

class DetailActivity : BaseComposeActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<DetailViewModel>
    private val vieModel: DetailViewModel by lazy { viewModelFactory.get() }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContent {
            RMCompose {
                DetailScreen(vieModel, intent.getIntExtra(Navigator.CHARACTER_ID, -1))
            }
        }
    }

}

