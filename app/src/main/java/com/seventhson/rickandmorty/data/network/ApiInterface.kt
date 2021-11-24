package com.seventhson.rickandmorty.data.network

import com.seventhson.rickandmorty.data.network.response.CharacterDetailResponse
import com.seventhson.rickandmorty.data.network.response.CharacterListResponse
import com.seventhson.rickandmorty.data.network.response.EpisodeDetailResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET("character")
    suspend fun getCharacters(@Query("page") page: Int) : Response<CharacterListResponse>

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") characterId: Int) : Response<CharacterDetailResponse>

    @GET("episode/{id}")
    suspend fun getEpisode(@Path("id") characterId: Int) : Response<EpisodeDetailResponse>

}