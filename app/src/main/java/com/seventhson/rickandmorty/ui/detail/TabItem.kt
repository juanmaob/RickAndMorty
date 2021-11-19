package com.seventhson.rickandmorty.ui.detail
import com.seventhson.rickandmorty.R

sealed class TabItem(val icon: Int, val title: String) {
    object Info : TabItem(R.drawable.ic_info, "Info")
    object Episodes : TabItem(R.drawable.ic_movie, "Episodes")
}