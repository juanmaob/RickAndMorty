package com.seventhson.rickandmorty.ui.main.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.seventhson.rickandmorty.R
import com.seventhson.rickandmorty.domain.model.Character
import com.seventhson.rickandmorty.ui.common.PillText
import com.seventhson.rickandmorty.ui.ui.theme.VeryLightGrey

@Composable
fun Item(
    character: Character,
    onItemClick: (Character) -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .clip(shape = RoundedCornerShape(16.dp))
            .clickable {
                onItemClick(character)
            }
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 8.dp)
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
                modifier = Modifier.size(54.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column(
                modifier = Modifier
                    .height(54.dp)
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Row(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                ) {
                    Text(
                        text = String.format("#%02d", character.id),
                        fontWeight = FontWeight.Medium,
                        fontSize = 10.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(4.dp).fillMaxHeight()
                            .align(Alignment.CenterVertically)
                    )
                    Text(character.name, fontWeight = FontWeight.Bold)
                }

                Spacer(Modifier.height(8.dp))

                Row {
                    PillText(
                        character.species,
                        backgroundColor = VeryLightGrey,
                        textColor = Color.DarkGray
                    )

                    Spacer(Modifier.width(8.dp))

                    PillText(
                        character.gender,
                        backgroundColor = VeryLightGrey,
                        textColor = Color.DarkGray
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ItemPreview() {
    Item(
        character = Character(
            id = 1,
            name = "Persone",
            species = "Humane",
            gender = "Elle",
            image = "https://picsum.photos/200"
        ),
        onItemClick = {}
    )
}