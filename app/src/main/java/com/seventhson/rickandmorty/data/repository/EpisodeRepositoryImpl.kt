package com.seventhson.rickandmorty.data.repository

import com.seventhson.rickandmorty.data.database.AppDatabase
import com.seventhson.rickandmorty.data.network.ApiInterface
import com.seventhson.rickandmorty.data.network.response.toDomain
import com.seventhson.rickandmorty.domain.model.Episode
import com.seventhson.rickandmorty.domain.repository.EpisodeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.transform
import javax.inject.Inject

class EpisodeRepositoryImpl @Inject constructor(
    private val database: AppDatabase,
    private val apiInterface: ApiInterface
) : EpisodeRepository, Repository() {

    override fun getEpisode(id: Int): Flow<Episode> = flow {
        apiCall { apiInterface.getEpisode(id) }
            .transform { episode ->
                emit(episode.toDomain())
            }
            .collect { episode ->
                emit(episode)
            }
    }
}