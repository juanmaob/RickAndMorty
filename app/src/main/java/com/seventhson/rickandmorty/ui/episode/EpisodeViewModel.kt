package com.seventhson.rickandmorty.ui.episode

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.seventhson.rickandmorty.domain.model.Episode
import com.seventhson.rickandmorty.domain.useCases.GetEpisodeUseCase
import com.seventhson.rickandmorty.ui.common.BaseViewModel
import com.seventhson.rickandmorty.utils.CustomException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EpisodeViewModel @Inject constructor(
    private val getEpisodeUseCase: GetEpisodeUseCase
) : BaseViewModel() {

    val episodeDetailState =  mutableStateOf(Episode())

    fun getEpisodeDetail(episodeId: Int) {
        loading.value = SHOW
        viewModelScope.launch {
            delay(1500)
            getEpisodeUseCase.setParams(episodeId)
            getEpisodeUseCase.executeCall()
                .catch {
                    loading.value = DISMISS
                    val ex = it as CustomException
                    errorMessage.value = mapOf(ex.code to (ex.message ?: ""))
                }
                .collect { episode ->
                    episodeDetailState.value = episode
                    loading.value = DISMISS
                }
        }
    }

}
