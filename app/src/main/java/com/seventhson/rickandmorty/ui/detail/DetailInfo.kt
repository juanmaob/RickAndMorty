package com.seventhson.rickandmorty.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.seventhson.rickandmorty.domain.model.CharacterDetail

@ExperimentalPagerApi
@Composable
fun DetailInfo(state: State<CharacterDetail?>) {
    val context = LocalContext.current
    state.value?.let {
        Column(modifier = Modifier.fillMaxSize()) {

            TabRow(selectedTabIndex = 0) {
                Tab(selected = true, onClick = { /*TODO*/ }) {}
                Tab(selected = false, onClick = { /*TODO*/ }) {}
            }

            HorizontalPager(count = 2) { page ->
                when (page) {
                    0 -> Text(text = "Pagina 1")
                    1 -> Text(text = "Pagina 1")
                }
            }
        }
    }

}
