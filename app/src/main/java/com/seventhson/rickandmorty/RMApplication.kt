package com.seventhson.rickandmorty

import android.app.Application
import com.seventhson.rickandmorty.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class RMApplication: Application(), HasAndroidInjector {


    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger(){
        DaggerApplicationComponent.builder().application(this).build().inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}