package com.example.cowrywisetest.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cowrywisetest.R
import com.example.cowrywisetest.ui.theme.CowryWiseMidBlue
import com.example.cowrywisetest.ui.theme.SansTypography
import com.example.cowrywisetest.utils.StringAnnotationTag


@Composable
fun ClickableTextWithLink(
    modifier: Modifier = Modifier,
    text: String = stringResource(R.string.mid_market_exchange_rate_at_13_38_utc),
    verticalPadding: Dp = 20.dp,
    textColor: Color = CowryWiseMidBlue,
    showInfoIcon:Boolean = true
) {

    val context = LocalContext.current
    val uriHandler = LocalUriHandler.current
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = verticalPadding),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        val annotatedText = buildAnnotatedString {
            val signUpStart = length
            append(text)
            val signUpEnd = length
            addStyle(
                SpanStyle(
                    color = textColor,
                    fontWeight = FontWeight.Normal,
                    textDecoration = TextDecoration.Underline
                ),
                signUpStart,
                signUpEnd,
            )
            addStringAnnotation(
                StringAnnotationTag.MARKET_LINK.name, "https://your-terms-link.com", signUpStart,
                signUpEnd,
            )

        }

        Row(verticalAlignment = Alignment.Bottom) {


            ClickableText(
                style = SansTypography.displayLarge.copy(
                    color = textColor,
                    fontSize = 19.sp,
                    lineHeight = 19.sp,
                    fontWeight = FontWeight.W900,
                    fontFamily = FontFamily(Font(R.font.josefin_sans)),
                ),
                text = annotatedText,
                onClick = { offset ->
                    annotatedText.getStringAnnotations(start = offset, end = offset).firstOrNull()?.let {
                        when (it.tag) {
                            StringAnnotationTag.MARKET_LINK.name -> {
                                uriHandler.openUri(it.item)
                            }
                        }
                    }
                }
            )
        }

        Spacer(modifier = Modifier.width(8.dp))
        if (showInfoIcon)
            Icon(
                Icons.Default.Info,
                contentDescription = "",
                tint = Color.LightGray.copy(alpha = 0.6f),
                modifier = Modifier.size(24.dp)
            )
    }
}
