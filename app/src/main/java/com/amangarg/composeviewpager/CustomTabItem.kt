package com.amangarg.composeviewpager

import androidx.compose.material.Tab
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun CustomTabItem(
    pagerState: PagerState,
    index: Int,
    item: String,
    onClick: () -> Unit
) {

    Tab(selectedContentColor = Color.Black,
        unselectedContentColor = Color.Black,
        selected = pagerState.currentPage == index,
        onClick = {
            onClick.invoke()
        }) {
        Text(text = item)
    }
}
