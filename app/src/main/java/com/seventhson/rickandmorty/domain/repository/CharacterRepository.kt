package com.seventhson.rickandmorty.domain.repository

import com.seventhson.rickandmorty.domain.model.Character
import com.seventhson.rickandmorty.domain.model.CharacterDetail
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    fun getCharacters(): Flow<List<Character>>
    fun getCharacter(id: Int): Flow<CharacterDetail>

}