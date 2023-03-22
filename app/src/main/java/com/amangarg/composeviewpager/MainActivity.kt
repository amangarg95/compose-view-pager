package com.amangarg.composeviewpager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.amangarg.composeviewpager.ui.theme.ComposeViewPagerTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeViewPagerTheme {
                // A surface container using the 'background' color from the theme
                val pagerState = rememberPagerState()
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        TabLayout(
                            modifier = Modifier,
                            listOf("First", "Second", "Third"),
                            pagerState
                        )
                        TabContent(modifier = Modifier, pagerState = pagerState, size = 3)
                    }
                }
            }
        }
    }
}