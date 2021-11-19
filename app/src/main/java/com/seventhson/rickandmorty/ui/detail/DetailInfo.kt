package com.seventhson.rickandmorty.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import com.seventhson.rickandmorty.domain.model.CharacterDetail
import com.seventhson.rickandmorty.ui.ui.theme.VeryLightGrey
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun DetailInfo(
    state: State<CharacterDetail?>,
    tabList: List<TabItem>
) {
    state.value?.let { detail ->
        Column(modifier = Modifier.fillMaxSize()) {
            val pagerState = rememberPagerState()
            val coroutineScope = rememberCoroutineScope()

            TabRow(
                backgroundColor = Color.White,
                selectedTabIndex = pagerState.currentPage,
                indicator = { tabPositions ->
                    TabRowDefaults.Indicator(
                        color = Color.Transparent,
                        modifier = Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
                    )
                }
            ) {
                tabList.forEachIndexed { index, tab ->
                    Tab(
                        selectedContentColor = Color.Black,
                        unselectedContentColor = VeryLightGrey,
                        icon = { Icon(painter = painterResource(id = tab.icon), contentDescription = null) },
                        text = { Text(tab.title, color = Color.DarkGray) },
                        selected = pagerState.currentPage == index,
                        onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } },
                    )
                }
            }

            HorizontalPager(
                count = tabList.size,
                state = pagerState
            ) { page ->
                when (page) {
                    0 -> DetailInfoPage(detail)
                    1 -> DetailEpisodesPage(detail.episode)
                }
            }
        }
    }

}
