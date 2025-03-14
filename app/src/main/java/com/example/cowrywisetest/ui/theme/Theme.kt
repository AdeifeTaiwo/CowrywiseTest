package com.example.cowrywisetest.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = CowryWiseBlue,
    secondary = CowryWiseGraphGradientOne,
    tertiary = CowryWiseLightBlue,
    outline = Color(0xFFF7F7F8),
)

private val LightColorScheme = lightColorScheme(
    primary = CowryWiseBlue,
    secondary = CowryWiseGraphGradientOne,
    tertiary = CowryWiseLightBlue,
    outline = Color(0xFFF7F7F8),

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

var isDarkTheme = false

@Composable
fun CowrywiseTestTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {

    isDarkTheme = darkTheme

    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val view = LocalView.current
    SideEffect {
        val window = (view.context as Activity).window

        window.statusBarColor = Color.White.toArgb()
        WindowCompat.getInsetsController(window, view).apply {
            isAppearanceLightStatusBars = !isDarkTheme
        }
    }


    MaterialTheme(
        colorScheme = colorScheme,
        typography = SansTypography,
        content = {
            ProvideTextStyle(
                value = SansTypography.titleMedium.copy(color = MaterialTheme.colorScheme.onBackground),
                content = content
            )
        }
    )
}