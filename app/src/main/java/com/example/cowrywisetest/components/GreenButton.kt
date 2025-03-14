package com.example.cowrywisetest.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cowrywisetest.ui.theme.CowryWiseFaintWhite
import com.example.cowrywisetest.ui.theme.CowryWiseGreen

@Composable
fun GreenButton(
    modifier: Modifier = Modifier,
    backgroundColor: Color = CowryWiseGreen,
    buttonText: String,
    cornerRadius: Dp = 4.dp,
    isLoading: Boolean = false,
    isDisabled: Boolean = false,
    disabledColor: Color = Color.Gray,
    onButtonClick: () -> Unit = {},

    ) {
    Button(
        onClick = {
            if (!isLoading && !isDisabled) onButtonClick.invoke() // Prevent click if disabled
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isDisabled) disabledColor else backgroundColor // Apply disabled color
        ),
        shape = RoundedCornerShape(cornerRadius),
        modifier = modifier.height(56.dp),
        enabled = !isDisabled // Disable the button functionality
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                color = Color.White,
                strokeWidth = 2.dp,
                modifier = Modifier.size(24.dp)
            )
        } else {
            Text(
                text = buttonText,
                color = CowryWiseFaintWhite,
                style = MaterialTheme.typography.titleSmall.copy(
                    fontWeight = FontWeight.W400,
                    fontSize = 24.sp
                ),
            )
        }
    }
}
