package com.seventhson.rickandmorty.ui.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.seventhson.rickandmorty.domain.model.CharacterDetail
import com.seventhson.rickandmorty.ui.ErrorDialog
import com.seventhson.rickandmorty.ui.MainUI2
import com.seventhson.rickandmorty.ui.ShowLoading
import com.seventhson.rickandmorty.ui.ui.theme.RickAndMortyTheme
import com.seventhson.rickandmorty.utils.Navigator
import com.seventhson.rickandmorty.utils.ViewModelFactory
import dagger.android.AndroidInjection
import javax.inject.Inject

class DetailActivity : ComponentActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<DetailViewModel>
    private val viewModel: DetailViewModel by lazy { viewModelFactory.get() }

    //override fun getViewBinding() = Unit

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        viewModel.getCharacterDetail(intent.getIntExtra(Navigator.CHARACTER_ID, -1))
        setContent {
            RickAndMortyTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    val showDialog = remember {
                        mutableStateOf(false)
                    }
                    showDialog.value = viewModel.errorMessage.observeAsState().value != null
                    var isLoading = viewModel.loading.observeAsState()
                    ErrorDialog(showDialog)
                    //ShowLoading(isLoading)
                    MainUI2(viewModel.characterDetailLiveData.observeAsState())
                }
            }
        }
    }

    private fun init() {
        setUpViews()
        setUpObservers()
        setUpClicks()
        viewModel.getCharacterDetail(intent.getIntExtra(Navigator.CHARACTER_ID, -1))
    }

    private fun setUpClicks() {
        //Do Something
    }

    private fun setUpObservers() {
        viewModel.errorMessage.observe(this) {
            //handleError(it)
        }
        viewModel.loading.observe(this) {
            //manageLoadingDialog(it)
        }
        viewModel.characterDetailLiveData.observe(this) { character ->
            //renderDetail(character)
        }
    }

    private fun setUpViews() {
        //Do Something
    }

    private fun renderDetail(character: CharacterDetail) {
        /*binding.ivDetail.fromUrl(character.image)
        binding.toolbarLayout.title = character.name
        binding.content.tvGender.text = character.gender
        binding.content.tvOrigin.text = character.origin
        binding.content.tvStatus.text = character.status
        binding.content.tvSpecie.text = character.species*/
    }

    inline fun <reified T : ViewModel> ViewModelFactory<T>.get(): T =
        ViewModelProvider(this@DetailActivity, this).get(T::class.java)
}

