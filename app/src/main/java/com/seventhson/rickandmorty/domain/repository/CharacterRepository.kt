package com.seventhson.rickandmorty.domain.repository

import com.seventhson.rickandmorty.domain.model.CharacterDetail
import com.seventhson.rickandmorty.domain.model.CharacterList
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    fun getCharacters(page: Int): Flow<CharacterList>
    fun getCharacter(id: Int): Flow<CharacterDetail>

}