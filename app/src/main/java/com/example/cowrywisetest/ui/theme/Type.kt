package com.example.cowrywisetest.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.unit.sp
import com.example.cowrywisetest.R

// Set of Material typography styles to start with
val SansTypography = Typography(
    bodyLarge = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        textMotion = TextMotion.Animated,
        letterSpacing = 0.5.sp
    ),
    displayLarge = TextStyle(
        fontSize = 57.sp,
        lineHeight = 64.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily(Font(R.font.josefin_sans)),
        textMotion = TextMotion.Animated,
    ),
    displayMedium = TextStyle(
        fontSize = 45.sp,
        lineHeight = 52.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily(Font(R.font.josefin_sans)),
        textMotion = TextMotion.Animated,
    ),
    displaySmall = TextStyle(
        fontSize = 36.sp,
        lineHeight = 44.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily(Font(R.font.josefin_sans)),
        textMotion = TextMotion.Animated,
    ),
    headlineLarge = TextStyle(
        fontSize = 32.sp,
        lineHeight = 40.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily(Font(R.font.josefin_sans)),
        textMotion = TextMotion.Animated,
    ),
    headlineMedium = TextStyle(
        fontSize = 28.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily(Font(R.font.josefin_sans)),
        textMotion = TextMotion.Animated,
    ),
    headlineSmall = TextStyle(
        fontSize = 24.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily(Font(R.font.josefin_sans)),
        textMotion = TextMotion.Animated,
    ),
    titleLarge = TextStyle(
        fontSize = 22.sp,
        fontWeight = FontWeight.W900,
        fontFamily = FontFamily(Font(R.font.josefin_sans)),
    ),
    titleMedium = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = FontFamily(Font(R.font.josefin_sans)),
        textMotion = TextMotion.Animated,
    ),
    titleSmall = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = FontFamily(Font(R.font.josefin_sans)),
        textMotion = TextMotion.Animated,
    ),
    labelLarge = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = FontFamily(Font(R.font.josefin_sans)),
        textMotion = TextMotion.Animated,
    ),
    labelMedium = TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = FontFamily(Font(R.font.josefin_sans)),
        textMotion = TextMotion.Animated,
    ),
    labelSmall = TextStyle(
        fontSize = 11.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = FontFamily(Font(R.font.josefin_sans)),
        textMotion = TextMotion.Animated,
    ),
    bodyMedium = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily(Font(R.font.josefin_sans)),
        textMotion = TextMotion.Animated,
    ),
    bodySmall = TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily(Font(R.font.josefin_sans)),
        textMotion = TextMotion.Animated,
    ),
)
