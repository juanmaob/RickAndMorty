package com.seventhson.rickandmorty.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.seventhson.rickandmorty.R
import com.seventhson.rickandmorty.domain.model.Character
import com.seventhson.rickandmorty.ui.common.PillText

@Composable
fun Item(
    character: Character,
    onItemClick: (Int) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable {
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
            modifier = Modifier
                .width(42.dp)
                .height(42.dp)
        )
        Column(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
            Text(character.name, fontWeight = FontWeight.Bold)
            Spacer(Modifier.width(8.dp))
            Row {
                PillText(character.species)
                Spacer(Modifier.width(8.dp))
                PillText(character.species)
            }
        }
    }
}