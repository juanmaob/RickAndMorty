package com.seventhson.rickandmorty.ui.detail

import android.os.Bundle
import com.seventhson.rickandmorty.databinding.ActivityDetailBinding
import com.seventhson.rickandmorty.domain.model.CharacterDetail
import com.seventhson.rickandmorty.ui.common.BaseActivity
import com.seventhson.rickandmorty.utils.Navigator
import com.seventhson.rickandmorty.utils.ViewModelFactory
import com.seventhson.rickandmorty.utils.fromUrl
import javax.inject.Inject

class DetailActivity : BaseActivity<ActivityDetailBinding>() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<DetailViewModel>
    private val viewModel: DetailViewModel by lazy { viewModelFactory.get() }

    override fun getViewBinding() = ActivityDetailBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
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
        viewModel.errorMessage.observe(this, {
            handleError(it)
        })
        viewModel.loading.observe(this, {
            manageLoadingDialog(it)
        })
        viewModel.characterDetailLiveData.observe(this, { character ->
            renderDetail(character)
        })
    }

    private fun setUpViews() {
        //Do Something
    }

    private fun renderDetail(character: CharacterDetail) {
        binding.ivDetail.fromUrl(character.image)
        binding.toolbarLayout.title = character.name
        binding.content.tvGender.text = character.gender
        binding.content.tvOrigin.text = character.origin
        binding.content.tvStatus.text = character.status
        binding.content.tvSpecie.text = character.species
    }
}