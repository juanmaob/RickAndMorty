package com.seventhson.rickandmorty.data.network

import com.seventhson.rickandmorty.data.network.response.CharacterDetailResponse
import com.seventhson.rickandmorty.data.network.response.InfoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("character")
    suspend fun getCharacters() : Response<InfoResponse>

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") characterId: Int) : Response<CharacterDetailResponse>

}