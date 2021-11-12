package com.seventhson.rickandmorty.data.repository

import com.seventhson.rickandmorty.data.database.AppDatabase
import com.seventhson.rickandmorty.data.network.ApiInterface
import com.seventhson.rickandmorty.data.network.response.toDomain
import com.seventhson.rickandmorty.domain.model.CharacterDetail
import com.seventhson.rickandmorty.domain.model.CharacterList
import com.seventhson.rickandmorty.domain.repository.CharacterRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.transform
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val database: AppDatabase,
    private val apiInterface: ApiInterface
) : CharacterRepository, Repository() {

    override fun getCharacters(page: Int): Flow<CharacterList> = flow {
        apiCall { apiInterface.getCharacters(page) }
            .transform { response ->
                emit(response.toDomain())
            }
            .collect { charaterList ->
                delay(500)
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