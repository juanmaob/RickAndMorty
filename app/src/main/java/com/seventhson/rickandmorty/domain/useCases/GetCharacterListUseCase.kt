package com.seventhson.rickandmorty.domain.useCases

import com.seventhson.rickandmorty.domain.model.Character
import com.seventhson.rickandmorty.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharacterListUseCase @Inject constructor(
    private val repository: CharacterRepository
) {

    fun executeCall(): Flow<List<Character>> = repository.getCharacters()

}