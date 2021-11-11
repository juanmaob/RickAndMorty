package com.seventhson.rickandmorty.di.module

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.seventhson.rickandmorty.data.database.AppDatabase
import com.seventhson.rickandmorty.utils.Navigator
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule() {

    @Provides
    @Singleton
    fun providesApplicationContext(application: Application): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun providesNavigator(): Navigator {
        return Navigator()
    }

    @Provides
    @Singleton
    fun provideDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "rickAndMorty.db").build()
    }
}