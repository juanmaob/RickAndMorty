package com.seventhson.rickandmorty.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidViewBinding
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import com.seventhson.rickandmorty.R
import com.seventhson.rickandmorty.databinding.ItemCharacterBinding
import com.seventhson.rickandmorty.domain.model.CharacterDetail
import com.seventhson.rickandmorty.domain.model.CharacterList
import com.seventhson.rickandmorty.ui.ui.theme.RickAndMortyTheme
import com.seventhson.rickandmorty.utils.DialogUtil
import com.seventhson.rickandmorty.utils.fromUrl

class TempActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

//@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RickAndMortyTheme {
        Greeting("Android")
    }
}

@Composable
fun MainUI2(state: State<CharacterDetail?>) {
    val context = LocalContext.current
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


@Composable
fun ErrorDialog(showDialog: MutableState<Boolean>) {

    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = {
                showDialog.value = false
            },
            text = {
                Text(
                    text = "Error",
                    color = Color.Black
                )
            },
            confirmButton = {
                TextButton(onClick = {
                    showDialog.value = false
                }) {
                    Text(text = "Cerrar")
                }
            },
            backgroundColor = Color.White
        )
    }
}

@Composable
fun ShowLoading(isLoading: State<Boolean>) {
    if (isLoading.value)
        CircularProgressIndicator()
}


@Composable
fun Lista(state: State<CharacterList?>, onItemClick: (Int) -> Unit) {
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