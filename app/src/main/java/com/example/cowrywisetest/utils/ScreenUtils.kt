package com.example.cowrywisetest.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalConfiguration
import com.google.accompanist.systemuicontroller.rememberSystemUiController

/**
 * a Screen util to be used to get Screen Height in [Dp]
 */
@Composable
fun getScreenHeight(): Int {
    val configuration = LocalConfiguration.current
    return configuration.screenHeightDp
}

/**
 * This is used to set property to make navigation bars visible or not
 */

@Composable
fun HideSystemBars() {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.isSystemBarsVisible = false
    }
}