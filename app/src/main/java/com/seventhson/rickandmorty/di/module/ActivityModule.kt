package com.seventhson.rickandmorty.di.module

import com.seventhson.rickandmorty.ui.detail.DetailActivity
import com.seventhson.rickandmorty.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun bindDetailActivity(): DetailActivity

}