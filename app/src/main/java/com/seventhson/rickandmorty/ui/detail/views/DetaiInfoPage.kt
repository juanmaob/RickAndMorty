package com.seventhson.rickandmorty.ui.detail.views

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.seventhson.rickandmorty.domain.model.CharacterDetail
import com.seventhson.rickandmorty.ui.common.KeyValueInfo

@Composable
fun DetailInfoPage(detail: CharacterDetail) {
    Column(modifier = Modifier.fillMaxSize().padding(8.dp)) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Box(modifier = Modifier.weight(1f)) { KeyValueInfo("Status", detail.status) }
            Box(modifier = Modifier.weight(1f)) { KeyValueInfo("Species", detail.species) }
            Box(modifier = Modifier.weight(1f)) { KeyValueInfo("Gender", detail.gender) }
        }

        KeyValueInfo("Origin", detail.origin)
        KeyValueInfo("Location", detail.location)
    }
}

@Preview
@Composable
fun DetailInfoPagePreview() {
    DetailInfoPage(
        CharacterDetail(
            id = 1,
            name = "Nombre",
            status = "Vivo",
            species = "Humano",
            type = "Tipo",
            gender = "Neutro",
            origin = "Tierra",
            location = "Tierra"
        )
    )
}