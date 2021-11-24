package com.seventhson.rickandmorty.domain.repository

import com.seventhson.rickandmorty.domain.model.Episode
import kotlinx.coroutines.flow.Flow

interface EpisodeRepository {

    fun getEpisode(id: Int): Flow<Episode>

}