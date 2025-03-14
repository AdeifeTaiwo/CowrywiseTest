package com.example.cowrywisetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.cowrywisetest.navigation.RootNavigationGraph
import com.example.cowrywisetest.ui.theme.CowrywiseTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CowryWiseTest(modifier = Modifier) {
                RootNavigationGraph(activity = this)
            }
        }
    }
}


@Composable
fun CowryWiseTest(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    val systemTheme = isSystemInDarkTheme()
    CowrywiseTestTheme(
        darkTheme = false //implement dark theme
    ) {
        content()
    }

}
