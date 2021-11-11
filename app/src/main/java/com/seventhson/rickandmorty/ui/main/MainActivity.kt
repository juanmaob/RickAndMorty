package com.seventhson.rickandmorty.ui.main

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.seventhson.rickandmorty.databinding.ActivityMainBinding
import com.seventhson.rickandmorty.ui.common.BaseActivity
import com.seventhson.rickandmorty.ui.main.adapter.CharacterAdapter
import com.seventhson.rickandmorty.utils.ViewModelFactory
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding>() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<MainViewModel>
    private val viewModel: MainViewModel by lazy { viewModelFactory.get() }

    override fun getViewBinding() = ActivityMainBinding.inflate(layoutInflater)

    private val _characterAdapter: CharacterAdapter by lazy {
        CharacterAdapter(this) { character, image ->
            navigator.goToDetail(this, character.id, image)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
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
        viewModel.errorMessage.observe(this, {
            handleError(it)
        })
        viewModel.loading.observe(this, {
            manageLoadingDialog(it)
        })
        viewModel.characterListLiveData.observe(this, { list ->
            _characterAdapter.addAll(list)
        })
    }

    private fun setUpViews() {

        //Do Something
    }

    private fun setUpRV() {
        binding.rvCharacters.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
            setHasFixedSize(true)
            adapter = _characterAdapter
        }
    }



}