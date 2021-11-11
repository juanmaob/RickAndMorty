package com.seventhson.rickandmorty.ui.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.seventhson.rickandmorty.domain.model.Character
import com.seventhson.rickandmorty.domain.model.CharacterDetail
import com.seventhson.rickandmorty.domain.useCases.GetCharacterDetailUseCase
import com.seventhson.rickandmorty.domain.useCases.GetCharacterListUseCase
import com.seventhson.rickandmorty.ui.common.BaseViewModel
import com.seventhson.rickandmorty.utils.CustomException
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailViewModel @Inject constructor(
    private val getCharacterDetailUseCase: GetCharacterDetailUseCase
) : BaseViewModel() {

    val characterDetailLiveData: MutableLiveData<CharacterDetail> by lazy {
        MutableLiveData<CharacterDetail>()
    }


    /*private val _uiState by mutableStateOf<UiState>()
    val uiState: State<UiState>
        get() = _uiState*/


    fun getCharacterDetail(characterId: Int) {
        loading.value = SHOW
        viewModelScope.launch {
            getCharacterDetailUseCase.setParams(characterId)
            getCharacterDetailUseCase.executeCall()
                .catch {
                    loading.value = DISMISS
                    val ex = it as CustomException
                    errorMessage.value = mapOf(ex.code to (ex.message ?: ""))
                }
                .collect { character ->
                    characterDetailLiveData.value = character
                    //errorMessage.value = mapOf(1 to ("ex.message ?: "))
                    loading.value = DISMISS
                }
        }
    }



}
