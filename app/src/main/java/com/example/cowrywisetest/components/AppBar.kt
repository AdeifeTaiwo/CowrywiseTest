package com.example.cowrywisetest.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.cowrywisetest.R
import com.example.cowrywisetest.ui.theme.CowryWiseGreen
import com.example.cowrywisetest.ui.theme.CowrywiseTestTheme
import com.example.cowrywisetest.ui.theme.SansTypography

/**
 * Standard Top app bar to show signup button and menu button on the left side
 * @param onClickMenuIcon - this is a callback when you click menu icon
 * @param onClickSignUp - this is a callback when you click the signup button
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBarGreen(
    titleText: String = "",
    onClickMenuIcon: () -> Unit,
    onClickSignUp: () -> Unit
) {

    CenterAlignedTopAppBar(
        modifier = Modifier,
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Transparent
        ),
        navigationIcon = {
            TextButton(onClick = onClickMenuIcon) {
                Image(
                    modifier = Modifier,
                    painter = painterResource(id = R.drawable.ic_side_menu),
                    contentDescription = null,
                )
            }
        },
        title = {
            Row(
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    titleText,
                    style = TextStyle(
                        fontWeight = FontWeight(500),
                        fontSize = 20.sp,
                        color = Color.Transparent
                    )
                )
            }
        },
        actions = {
            TextButton(onClick = onClickSignUp) {
                Text(
                    fontFamily = FontFamily(Font(R.font.josefin_sans)),
                    style = SansTypography.displayLarge.copy(
                        color = CowryWiseGreen,
                        fontSize = 20.sp
                    ),
                    text = "Sign up",
                    fontWeight = FontWeight.W600
                )
            }

        }
    )
}

/**
 * An Alternative Top app bar to show signup button and menu button on the left side
 * @param onClickMenuIcon - this is a callback when you click menu icon
 * @param onClickSignUp - this is a callback when you click the signup button
 */
@Composable
fun CowrywiseTopAppBar(
    onClickMenuIcon: () -> Unit,
    onClickSignUp: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TextButton(onClick = onClickMenuIcon) {
            Image(
                modifier = Modifier,
                painter = painterResource(id = R.drawable.ic_side_menu),
                contentDescription = null,
            )
        }

        TextButton(onClick = onClickSignUp) {
            Text(
                fontFamily = FontFamily(Font(R.font.josefin_sans)),
                style = SansTypography.displayLarge.copy(
                    color = CowryWiseGreen,
                    fontSize = 20.sp
                ),
                text = "Sign up",
                fontWeight = FontWeight.W600
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
fun PreviewAppBar() {
    CowrywiseTestTheme {
        AppBarGreen(titleText = "", onClickMenuIcon = {}) { }
    }
}