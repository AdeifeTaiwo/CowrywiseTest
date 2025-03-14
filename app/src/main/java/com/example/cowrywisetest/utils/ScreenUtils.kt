package com.example.cowrywisetest.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalConfiguration
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun getScreenHeight(): Int {
    val configuration = LocalConfiguration.current
    return configuration.screenHeightDp
}

@Composable
fun HideSystemBars() {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.isSystemBarsVisible = false
    }
}