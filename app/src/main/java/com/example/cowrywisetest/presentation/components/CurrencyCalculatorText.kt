package com.example.cowrywisetest.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cowrywisetest.R
import com.example.cowrywisetest.ui.theme.CowryWiseGreen
import com.example.cowrywisetest.ui.theme.CowryWiseMidBlue
import com.example.cowrywisetest.ui.theme.SansTypography


@Composable
fun CurrencyCalculatorText() {
    Column(modifier = Modifier.padding(vertical = 40.dp)) {
        val annotatedText = buildAnnotatedString {
            val signUpStart = length
            append(stringResource(R.string.currency))
            val signUpEnd = length
            addStyle(
                SpanStyle(color = CowryWiseMidBlue, fontWeight = FontWeight.W900),
                signUpStart,
                signUpEnd
            )

            val termsStart = length
            append(stringResource(R.string.calculator_text))
            val termsEnd = length
            addStyle(
                SpanStyle(color = CowryWiseMidBlue, fontWeight = FontWeight.W900),
                termsStart,
                termsEnd
            )

            val fullStopStart = length
            append(".")
            val fullStopEnd = length
            addStyle(
                SpanStyle(
                    color = CowryWiseGreen,
                    fontWeight = FontWeight.W900,
                    fontSize = 50.sp
                ), fullStopStart, fullStopEnd
            )

        }


        Row(verticalAlignment = Alignment.Bottom) {
            Text(
                fontFamily = FontFamily(Font(R.font.josefin_sans)),
                style = SansTypography.displayLarge.copy(
                    color = CowryWiseMidBlue,
                    fontSize = 40.sp,
                    lineHeight = 40.sp,
                    fontWeight = FontWeight.W900
                ),
                text = annotatedText,
            )

        }


    }
}