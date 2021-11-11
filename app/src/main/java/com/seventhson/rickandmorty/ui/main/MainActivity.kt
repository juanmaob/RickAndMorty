package com.seventhson.rickandmorty.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.seventhson.rickandmorty.ui.Lista
import com.seventhson.rickandmorty.ui.ui.theme.RickAndMortyTheme
import com.seventhson.rickandmorty.utils.Navigator
import com.seventhson.rickandmorty.utils.ViewModelFactory
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<MainViewModel>
    private val viewModel: MainViewModel by lazy { viewModelFactory.get() }

    //override fun getViewBinding() = ActivityMainBinding.inflate(layoutInflater)

    /*private val _characterAdapter: CharacterAdapter by lazy {
        CharacterAdapter(this) { character, image ->
            navigator.goToDetail(this, character.id, image)
        }
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        viewModel.getCharacterList()
        setContent {
            RickAndMortyTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Lista(viewModel.characterListLiveData.observeAsState()) {
                        Navigator().goToDetail(this, it, null)
                    }
                }
            }
        }
    }

    private fun init() {
        setUpViews()
        setUpObservers()
        setUpClicks()
        setUpRV()
        viewModel.getCharacterList()

    }

    private fun setUpClicks() {

        //Do Something
    }

    private fun setUpObservers() {
        /*viewModel.errorMessage.observe(this) {
            handleError(it)
        }
        viewModel.loading.observe(this) {
            manageLoadingDialog(it)
        }
        viewModel.characterListLiveData.observe(this) { list ->
            _characterAdapter.addAll(list)
        }*/
    }

    private fun setUpViews() {

        //Do Something
    }

    private fun setUpRV() {
        /*binding.rvCharacters.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
            setHasFixedSize(true)
            adapter = _characterAdapter
        }*/
    }

    inline fun <reified T : ViewModel> ViewModelFactory<T>.get(): T =
        ViewModelProvider(this@MainActivity, this).get(T::class.java)

}