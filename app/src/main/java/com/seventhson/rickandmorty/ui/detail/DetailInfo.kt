package com.seventhson.rickandmorty.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidViewBinding
import coil.compose.rememberImagePainter
import coil.transform.RoundedCornersTransformation
import com.seventhson.rickandmorty.databinding.ItemCharacterBinding
import com.seventhson.rickandmorty.domain.model.CharacterDetail
import com.seventhson.rickandmorty.utils.DialogUtil
import com.seventhson.rickandmorty.utils.fromUrl

@Composable
fun DetailInfo(state: State<CharacterDetail?>) {
    val context = LocalContext.current
    state.value?.let {
        Column(modifier = Modifier.fillMaxSize()) {

            AndroidViewBinding(factory = ItemCharacterBinding::inflate) {
                ivAvatar.fromUrl(state.value?.image ?: "")
                tvName.text = state.value?.name
                tvSpecie.text = state.value?.species
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(all = 16.dp)
            ) {

                Image(
                    painter = rememberImagePainter(
                        data = state.value?.image,
                        builder = {
                            transformations(RoundedCornersTransformation(16f))
                            crossfade(true)
                        }),
                    contentDescription = null,
                    modifier = Modifier
                        .clickable {
                            DialogUtil().showDatePicker(context = context) {}
                        }
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.secondary)
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Title 2")
            }
        }
    }

}
