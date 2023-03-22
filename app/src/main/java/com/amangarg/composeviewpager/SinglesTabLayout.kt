package com.amangarg.composeviewpager

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabLayout(modifier: Modifier, tabData: List<String>, pagerState: PagerState) {
    val scope = rememberCoroutineScope()

    TabRow(
        backgroundColor = Color.White,
        selectedTabIndex = pagerState.currentPage,
        divider = {
            Spacer(modifier = Modifier.height(24.dp))
        },
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                height = 2.dp,
                color = Color.Black
            )
        },
        modifier = modifier
            .wrapContentHeight()
            .fillMaxWidth()
    ) {
        tabData.forEachIndexed { index, singlesTabItem ->
            CustomTabItem(
                pagerState = pagerState,
                index = index,
                item = singlesTabItem
            ) {
                scope.launch {
                    pagerState.animateScrollToPage(index)
                }
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabContent(
    modifier: Modifier,
    pagerState: PagerState,
    size: Int
) {
    HorizontalPager(modifier = modifier, state = pagerState, count = size) { index ->
        when (index) {
            0 -> {
                FirstScreen(modifier)
            }

            1 -> {
                SecondScreen(modifier)
            }

            2 -> {
                ThirdScreen(modifier)
            }
        }
    }
}