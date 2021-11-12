package com.seventhson.rickandmorty.ui.common

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.seventhson.rickandmorty.data.sharedPreferences.SharedPrefs
import com.seventhson.rickandmorty.utils.Navigator
import com.seventhson.rickandmorty.utils.ViewModelFactory
import dagger.android.AndroidInjection
import javax.inject.Inject

abstract class BaseComposeActivity: ComponentActivity() {

    @Inject
    lateinit var navigator: Navigator

    @Inject
    lateinit var sharedPrefs: SharedPrefs

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }


    inline fun <reified T : ViewModel> ViewModelFactory<T>.get(): T =
        ViewModelProvider(this@BaseComposeActivity, this).get(T::class.java)

}