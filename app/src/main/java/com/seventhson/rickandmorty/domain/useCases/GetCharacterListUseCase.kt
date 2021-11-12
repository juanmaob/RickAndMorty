package com.seventhson.rickandmorty.domain.useCases

import com.seventhson.rickandmorty.domain.model.CharacterList
import com.seventhson.rickandmorty.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharacterListUseCase @Inject constructor(
    private val repository: CharacterRepository
) {

    private var _page: Int = 1

    fun setParams(page: Int?) {
        this._page = page ?: 1
    }

    fun executeCall(): Flow<CharacterList> = repository.getCharacters(_page)

}