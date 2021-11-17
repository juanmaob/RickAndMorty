package com.seventhson.rickandmorty.di.module


import com.seventhson.rickandmorty.data.database.AppDatabase
import com.seventhson.rickandmorty.data.network.ApiInterface
import com.seventhson.rickandmorty.data.repository.CharacterRepositoryImpl
import com.seventhson.rickandmorty.domain.repository.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun providesAccountRepositoryRepository(database: AppDatabase, apiInterface: ApiInterface): CharacterRepository {
        return CharacterRepositoryImpl(database, apiInterface)
    }


}