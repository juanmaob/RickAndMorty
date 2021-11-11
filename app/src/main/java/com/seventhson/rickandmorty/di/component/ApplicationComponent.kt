package com.seventhson.rickandmorty.di.component

import android.app.Application
import com.seventhson.rickandmorty.RMApplication
import com.seventhson.rickandmorty.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class,
    ApplicationModule::class,
    NetworkModule::class,
    ActivityModule::class,
    FragmentModule::class,
    RepositoryModule::class])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: RMApplication)

}