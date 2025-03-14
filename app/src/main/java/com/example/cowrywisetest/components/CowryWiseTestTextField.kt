package com.example.cowrywisetest.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cowrywisetest.ui.theme.SansTypography


@Composable
fun CowryWiseTestTextField(
    value: String = "",
    onValueChange: (String) -> Unit = { _ -> },
    label: String = "1",
    singleLine: Boolean = true,
    isReadOnly: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Ascii,
    trailingIcon: @Composable (() -> Unit)? = null
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.outline,
                shape = RoundedCornerShape(4.dp) // Apply rounded corners
            )
    ) {
        TextField(
            value = value,
            readOnly = isReadOnly,
            onValueChange = onValueChange,
            placeholder = { Text(label, color = Color(0xFF8A9199), style = SansTypography.titleMedium.copy(
                fontSize = 18.sp,
                fontWeight = FontWeight.W400
            )) },
            trailingIcon = trailingIcon,
            modifier = Modifier.fillMaxWidth(),
            singleLine = singleLine,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            keyboardActions = KeyboardActions(onDone = {keyboardController?.hide()},
                onNext = {keyboardController?.hide()}),
            textStyle = TextStyle(
                fontSize = 18.sp,
                color = Color.Black.copy(alpha = 0.7f),
                fontWeight = FontWeight.W500
            )
        )
    }
}


@Composable
fun CowryWiseTestCustomTextField(
    value: String = "",
    onValueChange: (String) -> Unit = { _ -> },
    label: String = "1",
    singleLine: Boolean = true,
    isReadOnly: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Ascii,
    trailingIcon: @Composable (() -> Unit)? = null
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    val styledText = buildAnnotatedString {
        val dotIndex = value.indexOf(".") // Find the position of the dot

        if (dotIndex == -1) {
            // No decimal point: Make everything bold and black
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Black)) {
                append(value)
            }
        } else {
            // Before the dot (Black & Bold)
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Black)) {
                append(value.substring(0, dotIndex + 1)) // Include the dot
            }

            // After the dot (Gray)
            withStyle(style = SpanStyle(color = Color.Gray)) {
                append(value.substring(dotIndex + 1)) // Everything after the dot
            }
        }
    }


    Box(
        modifier = Modifier
            .fillMaxWidth()

            .background(
                color = MaterialTheme.colorScheme.outline,
                shape = RoundedCornerShape(4.dp) // Apply rounded corners
            )
    ) {


        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            readOnly = isReadOnly,
            textStyle = TextStyle(
                fontSize = 18.sp,
                color = Color.Black.copy(alpha = 0.7f),
                fontWeight = FontWeight.W500
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),

            keyboardActions = KeyboardActions(onDone = {keyboardController?.hide()},
                onNext = {keyboardController?.hide()}),

            decorationBox = { innerTextField ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFF5F5F5), RoundedCornerShape(8.dp))
                        .padding( vertical = 16.dp)
                        .padding(start = 8.dp, end = 8.dp)
                ) {
                    Text(text = styledText, fontSize = 20.sp)

                    trailingIcon?.invoke()
                    //innerTextField()
                }
            }
        )
    }
}

