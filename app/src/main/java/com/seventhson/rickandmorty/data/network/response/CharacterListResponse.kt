package com.seventhson.rickandmorty.data.network.response

import com.google.gson.annotations.SerializedName
import com.seventhson.rickandmorty.domain.model.Character
import com.seventhson.rickandmorty.domain.model.CharacterList

data class CharacterListResponse(
    @SerializedName("info")
    val pageInfo: InfoResponse,
    @SerializedName("results")
    var charecterResponseList: List<CharacterResponse> = listOf()
)

data class InfoResponse(
    val next: String
)

data class CharacterResponse(
    var id: Int?,
    var name: String?,
    var species: String?,
    var gender: String?,
    var image: String?
)

fun CharacterListResponse.toDomain() : CharacterList {
    return CharacterList(
        nextPage = pageInfo.next.substringAfterLast("page=").toIntOrNull() ?: 1,
        list = charecterResponseList.map {
            Character(
                id = it.id ?: 0,
                name = it.name ?: "",
                species = it.species ?: "",
                gender = it.gender ?: "",
                image = it.image ?: ""
            )
        }.toMutableList()
    )
}

