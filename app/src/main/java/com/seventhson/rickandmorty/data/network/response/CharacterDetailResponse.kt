package com.seventhson.rickandmorty.data.network.response

import com.google.gson.annotations.SerializedName
import com.seventhson.rickandmorty.domain.model.CharacterDetail


data class CharacterDetailResponse(
    @SerializedName("id")
    var id: Int?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("status")
    var status: String?,
    @SerializedName("species")
    var species: String?,
    @SerializedName("type")
    var type: String?,
    @SerializedName("gender")
    var gender: String?,
    @SerializedName("origin")
    var origin: Origin?,
    @SerializedName("location")
    var location: Location?,
    @SerializedName("image")
    var image: String?,
    @SerializedName("episode")
    var episode: List<String>?,
    @SerializedName("url")
    var url: String?,
    @SerializedName("created")
    var created: String?
)

data class Origin(
    @SerializedName("name")
    var name: String?,
    @SerializedName("url")
    var url: String?
)

data class Location(
    @SerializedName("name")
    var name: String?,
    @SerializedName("url")
    var url: String?
)

fun CharacterDetailResponse.toDomain(): CharacterDetail {
    return CharacterDetail(
        id = this.id ?: 0,
        name = this.name ?: "",
        status = this.status ?: "",
        species = this.species ?: "",
        type = this.type ?: "",
        gender = this.gender ?: "",
        origin = this.origin?.name ?: "",
        location = this.location?.name ?: "",
        image = this.image ?: "",
        url = this.url ?: "",
        created = this.created ?: "",
        episode = this.episode ?: listOf()
    )
}