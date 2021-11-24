package com.seventhson.rickandmorty.domain.useCases

import com.seventhson.rickandmorty.domain.model.Episode
import com.seventhson.rickandmorty.domain.repository.EpisodeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetEpisodeUseCase @Inject constructor(
    private val repository: EpisodeRepository
) {

    private var _episodeId: Int = -1

    fun setParams(episodeId: Int) {
        this._episodeId = episodeId
    }

    fun executeCall(): Flow<Episode> = repository.getEpisode(_episodeId)

}