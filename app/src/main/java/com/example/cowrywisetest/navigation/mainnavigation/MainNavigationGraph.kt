package com.example.cowrywisetest.navigation.mainnavigation

import android.app.Activity
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.cowrywisetest.navigation.Graph
import com.example.cowrywisetest.navigation.Screens
import com.example.cowrywisetest.presentation.home.CalculatorHomeScreen
import com.example.cowrywisetest.presentation.home.CalculatorHomeViewModel
import com.example.cowrywisetest.presentation.splash.SplashScreen


fun NavGraphBuilder.mainGraph(
    activity: Activity,
    navHostController: NavHostController,

    ) {


    navigation(route = Graph.MAIN, startDestination = Screens.SplashScreen.name) {

        composable(Screens.SplashScreen.name) {
            SplashScreen(navHostController)
        }
        composable(Screens.CalculatorHomeScreen.name) {
            val welcomeScreenViewModel: CalculatorHomeViewModel = hiltViewModel()
            val uiState = welcomeScreenViewModel.countryListState.collectAsState().value

            CalculatorHomeScreen(
                uiState = uiState,
                onClickSignUp = {},
                onClickMenuIcon = {}
            )
        }

    }
}

