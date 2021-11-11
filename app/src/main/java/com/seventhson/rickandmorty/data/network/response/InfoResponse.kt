package com.seventhson.rickandmorty.data.network.response

import com.google.gson.annotations.SerializedName
import com.seventhson.rickandmorty.domain.model.Character

data class InfoResponse(
    @SerializedName("results")
    var charecterResponseList: List<CharacterResponse> = listOf()
)

data class CharacterResponse(
    @SerializedName("id")
    var id: Int?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("species")
    var species: String?,
    @SerializedName("image")
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
