package com.seventhson.rickandmorty.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.seventhson.rickandmorty.databinding.ItemCharacterBinding
import com.seventhson.rickandmorty.domain.model.Character

class CharacterAdapter(
    private val context: Context,
    private val onItemClick: (Character, ImageView) -> Unit)
    : RecyclerView.Adapter<CharacterViewHolder>() {

    var list: MutableList<Character> = mutableListOf()

    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = ItemCharacterBinding.inflate(LayoutInflater.from(context), parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val item = list[position]
        holder.render(item, onItemClick)
    }

    fun addAll(itemList: List<Character>) {
        list.clear()
        list.addAll(itemList)
        notifyDataSetChanged()
    }

}