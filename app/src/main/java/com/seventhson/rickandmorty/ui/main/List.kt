package com.seventhson.rickandmorty.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.seventhson.rickandmorty.R
import com.seventhson.rickandmorty.domain.model.CharacterList

@Composable
fun List(state: State<CharacterList?>, onItemClick: (Int) -> Unit) {
    LazyColumn (
        modifier = Modifier.fillMaxSize()
    ) {
        state.value?.let {
            items(it.list) { character ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp).clickable {
                        onItemClick(character.id)
                    }

                ) {
                    Image(
                        painter = rememberImagePainter(
                            data = character.image,
                            builder = {
                                transformations(CircleCropTransformation())
                                crossfade(true)
                                placeholder(drawableResId = R.drawable.ic_launcher_foreground)
                            }),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.width(42.dp).height(42.dp)
                    )
                    Column (
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    ){
                        Text(character.name)
                        Text(character.species)
                    }
                }
            }
        }


    }
}