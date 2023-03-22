package com.amangarg.composeviewpager

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState

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