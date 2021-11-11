package com.seventhson.rickandmorty.data.network.response

import com.google.gson.annotations.SerializedName
import com.seventhson.rickandmorty.domain.model.Character

data class InfoResponse(
    @SerializedName("results")
    var charecterResponseList: List<CharacterResponse> = listOf()
)

data class CharacterResponse(
    var id: Int?,
    var name: String?,
    var species: String?,
    var image: String?
)

fun List<CharacterResponse>.toDomain() : List<Character>{
    return map {
        Character(
            id = it.id ?: 0,
            name = it.name ?: "",
            species = it.species ?: "",
            image = it.image ?: ""
        )
    }
}

