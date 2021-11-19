package com.seventhson.rickandmorty.ui.detail
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.seventhson.rickandmorty.domain.model.CharacterDetail
import com.seventhson.rickandmorty.domain.useCases.GetCharacterDetailUseCase
import com.seventhson.rickandmorty.ui.common.BaseViewModel
import com.seventhson.rickandmorty.utils.CustomException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getCharacterDetailUseCase: GetCharacterDetailUseCase
) : BaseViewModel() {

    val characterDetailLiveData: MutableLiveData<CharacterDetail> by lazy {
        MutableLiveData<CharacterDetail>()
    }

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
