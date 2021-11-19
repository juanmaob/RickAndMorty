package com.seventhson.rickandmorty.domain.model


data class CharacterList(
    var nextPage: Int,
    var list: List<Character>
)

data class Character(
    var id: Int,
    var name: String,
    var species: String,
    var image: String
)

data class CharacterDetail(
    var id: Int,
    var name: String,
    var status: String,
    var species: String,
    var type: String,
    var gender: String,
    var origin: String,
    var location: String,
    var image: String,
    var url: String,
    var created: String,
    val episode: List<String>
)