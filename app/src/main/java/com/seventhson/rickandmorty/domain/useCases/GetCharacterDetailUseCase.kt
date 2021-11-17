package com.seventhson.rickandmorty.domain.useCases

import com.seventhson.rickandmorty.domain.model.CharacterDetail
import com.seventhson.rickandmorty.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharacterDetailUseCase @Inject constructor(
    private val repository: CharacterRepository
) {

    private var _characterId: Int = -1

    fun setParams(characterId: Int) {
        this._characterId = characterId
    }

    fun executeCall(): Flow<CharacterDetail> = repository.getCharacter(_characterId)

}