package com.seventhson.rickandmorty.ui.main

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.viewModelScope
import com.seventhson.rickandmorty.domain.model.Character
import com.seventhson.rickandmorty.domain.model.CharacterList
import com.seventhson.rickandmorty.domain.useCases.GetCharacterListUseCase
import com.seventhson.rickandmorty.ui.common.BaseViewModel
import com.seventhson.rickandmorty.utils.CustomException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCharacterListUseCase: GetCharacterListUseCase
) : BaseViewModel() {

    private val characterListData = CharacterList(1, listOf())

    var characterListState = mutableStateListOf<Character>()
        private set

    init {
        getCharacterList()
    }

    fun getCharacterList() {
         loading.value = SHOW

        viewModelScope.launch {

            getCharacterListUseCase.setParams(characterListData.nextPage)
            getCharacterListUseCase.executeCall()
                .catch {
                    loading.value = DISMISS
                    val ex = it as CustomException
                    errorMessage.value = mapOf(ex.code to (ex.message ?: ""))
                }
                .collect { characterList ->
                    characterListData.apply {
                        list = characterListData.list.plus(characterList.list)
                        nextPage = characterList.nextPage
                    }
                    characterListState.addAll(characterList.list)
                    loading.value = DISMISS
                }
        }
    }

}