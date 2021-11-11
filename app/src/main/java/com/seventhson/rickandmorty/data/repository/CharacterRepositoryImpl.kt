package com.seventhson.rickandmorty.data.repository

import com.seventhson.rickandmorty.data.database.AppDatabase
import com.seventhson.rickandmorty.data.network.ApiInterface
import com.seventhson.rickandmorty.data.network.response.toDomain
import com.seventhson.rickandmorty.domain.model.Character
import com.seventhson.rickandmorty.domain.model.CharacterDetail
import com.seventhson.rickandmorty.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.transform
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val database: AppDatabase,
    private val apiInterface: ApiInterface
) : CharacterRepository, Repository() {

    override fun getCharacters(): Flow<List<Character>> = flow {
        apiCall { apiInterface.getCharacters() }
            .transform { infoResponse ->
                emit(infoResponse.charecterResponseList.toDomain())
            }
            .collect { charaterList ->
                emit(charaterList)
            }
    }

    override fun getCharacter(id: Int): Flow<CharacterDetail> = flow {
        apiCall { apiInterface.getCharacter(id) }
            .transform { character ->
                emit(character.toDomain())
            }
            .collect { character ->
                emit(character)
            }
    }
}