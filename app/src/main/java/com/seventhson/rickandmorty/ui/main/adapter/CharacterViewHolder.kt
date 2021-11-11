package com.seventhson.rickandmorty.ui.main.adapter

import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.seventhson.rickandmorty.databinding.ItemCharacterBinding
import com.seventhson.rickandmorty.domain.model.Character
import com.seventhson.rickandmorty.utils.fromUrl

class CharacterViewHolder(private val binding: ItemCharacterBinding) : RecyclerView.ViewHolder(binding.root) {

    fun render(
        item: Character,
        onItemClick: (Character, ImageView) -> Unit
    ) {

        binding.tvName.text = item.name
        binding.tvSpecie.text = item.species
        binding.ivAvatar.fromUrl(item.image)

        itemView.setOnClickListener { onItemClick(item, binding.ivAvatar) }

    }

}