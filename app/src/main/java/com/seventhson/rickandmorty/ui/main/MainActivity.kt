package com.seventhson.rickandmorty.ui.main

import android.os.Bundle
import androidx.activity.compose.setContent
import com.seventhson.rickandmorty.ui.common.BaseComposeActivity
import com.seventhson.rickandmorty.ui.common.RMCompose
import com.seventhson.rickandmorty.utils.Navigator
import com.seventhson.rickandmorty.utils.ViewModelFactory
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : BaseComposeActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<MainViewModel>
    private val viewModel: MainViewModel by lazy { viewModelFactory.get() }


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContent {
            RMCompose {
                MainScreen(viewModel) {
                    Navigator().goToDetail(this, it, null)
                }
            }
        }
    }

}