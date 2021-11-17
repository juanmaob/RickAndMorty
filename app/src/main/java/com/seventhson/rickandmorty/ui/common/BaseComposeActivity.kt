package com.seventhson.rickandmorty.ui.common

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.seventhson.rickandmorty.data.sharedPreferences.SharedPrefs
import com.seventhson.rickandmorty.utils.Navigator
import javax.inject.Inject

abstract class BaseComposeActivity: ComponentActivity() {

    @Inject
    lateinit var navigator: Navigator

    @Inject
    lateinit var sharedPrefs: SharedPrefs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}