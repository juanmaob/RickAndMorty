package com.seventhson.rickandmorty.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.seventhson.rickandmorty.domain.model.Character
import com.seventhson.rickandmorty.domain.useCases.GetCharacterListUseCase
import com.seventhson.rickandmorty.ui.common.BaseViewModel
import com.seventhson.rickandmorty.utils.CustomException
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getCharacterListUseCase: GetCharacterListUseCase
) : BaseViewModel() {

    val characterListLiveData: MutableLiveData<List<Character>> by lazy {
        MutableLiveData<List<Character>>()
    }

    fun getCharacterList() {
        loading.value = SHOW
        viewModelScope.launch {
            getCharacterListUseCase.executeCall()
                .catch {
                    loading.value = DISMISS
                    val ex = it as CustomException
                    errorMessage.value = mapOf(ex.code to (ex.message ?: ""))
                }
                .collect { characterList ->
                    characterListLiveData.value = characterList
                    loading.value = DISMISS
                }
        }
    }

}