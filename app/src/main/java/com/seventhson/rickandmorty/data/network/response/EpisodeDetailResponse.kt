package com.seventhson.rickandmorty.data.network.response

import com.google.gson.annotations.SerializedName
import com.seventhson.rickandmorty.domain.model.Episode

data class EpisodeDetailResponse(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("air_date")
    val air_date: String?,
    @SerializedName("episode")
    val episode: String?,
    @SerializedName("characters")
    val characters: List<String>?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("created")
    val created: String?
)

fun EpisodeDetailResponse.toDomain(): Episode {
    return Episode(
        id = id,
        name = name,
        air_date = air_date,
        episode = episode,
        characters = characters,
        url = url,
        created = created
    )
}