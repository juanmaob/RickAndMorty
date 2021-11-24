package com.seventhson.rickandmorty.ui.episode

import com.seventhson.rickandmorty.domain.useCases.GetEpisodeUseCase
import com.seventhson.rickandmorty.ui.common.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EpisodeViewModel @Inject constructor(
    private val getEpisodeUseCase: GetEpisodeUseCase
) : BaseViewModel() {

    /*val episodeDetailLiveData: MutableLiveData<EpisodeDetail> by lazy {
        MutableLiveData<EpisodeDetail>()
    }

    fun getEpisodeDetail(episodeId: Int) {
        loading.value = SHOW
        
        viewModelScope.launch {
            getEpisodeDetailUseCase.setParams(episodeId)
            getEpisodeDetailUseCase.executeCall()
                .catch {
                    loading.value = DISMISS
                    val ex = it as CustomException
                    errorMessage.value = mapOf(ex.code to (ex.message ?: ""))
                }
                .collect { episode ->
                    episodeDetailLiveData.value = episode
                    loading.value = DISMISS
                }
        }
    }

*/

}
