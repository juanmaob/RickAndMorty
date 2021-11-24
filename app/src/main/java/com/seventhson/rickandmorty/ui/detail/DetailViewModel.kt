package com.seventhson.rickandmorty.ui.detail
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.seventhson.rickandmorty.domain.model.CharacterDetail
import com.seventhson.rickandmorty.domain.useCases.GetCharacterDetailUseCase
import com.seventhson.rickandmorty.ui.common.BaseViewModel
import com.seventhson.rickandmorty.utils.CustomException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getCharacterDetailUseCase: GetCharacterDetailUseCase
) : BaseViewModel() {

    val characterDetailState =  mutableStateOf(CharacterDetail())

    fun getCharacterDetail(characterId: Int) {
        loading.value = SHOW
        viewModelScope.launch {
            delay(1500)
            getCharacterDetailUseCase.setParams(characterId)
            getCharacterDetailUseCase.executeCall()
                .catch {
                    loading.value = DISMISS
                    val ex = it as CustomException
                    errorMessage.value = mapOf(ex.code to (ex.message ?: ""))
                }
                .collect { character ->
                    characterDetailState.value = character
                    loading.value = DISMISS
                }
        }
    }



}
