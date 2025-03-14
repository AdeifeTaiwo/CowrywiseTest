package com.example.cowrywisetest.presentation.splash

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cowrywisetest.navigation.Screens
import com.example.cowrywisetest.ui.theme.CowryWiseBlue
import com.example.cowrywisetest.ui.theme.CowrywiseTestTheme
import com.example.cowrywisetest.ui.theme.SansTypography
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(
    navController: NavController,
    popUpToScreen: String = Screens.SplashScreen.name,
    navigateToScreen: String = Screens.CalculatorHomeScreen.name
) {
    var isVisible by remember { mutableStateOf(true) }
    val offsetX = remember { Animatable(-300f) }

    CowrywiseTestTheme() {
        LaunchedEffect(Unit) {
            offsetX.animateTo(
                targetValue = 0f,
                animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing)
            )

            delay(4000) // Show splash for 3 seconds
            isVisible = false
            navController.navigate(navigateToScreen) {
                popUpTo(popUpToScreen) { inclusive = true } // Remove splash from back stack
            }
        }


        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "CowryWise Assessment ",
                color = CowryWiseBlue,
                style = SansTypography.displayMedium.copy(
                    fontWeight = FontWeight.W700,
                    fontSize = 40.sp
                ),
                modifier = Modifier
                    .padding(bottom = 24.dp)
                    .offset(x = offsetX.value.dp)
            )
        }
    }
}

@Preview(
    name = "Dark Mode",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Preview(
    name = "Light Mode",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO
)
@Composable
fun SplashScreenPreview() {
    CowrywiseTestTheme() {
        SplashScreen(navController = rememberNavController())
    }
}
