package com.example.cowrywisetest.presentation.home


import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cowrywisetest.R
import com.example.cowrywisetest.components.CowryWiseTestCustomTextField
import com.example.cowrywisetest.components.CowryWiseTestTextField
import com.example.cowrywisetest.components.CowrywiseCustomLoader
import com.example.cowrywisetest.components.CowrywiseTopAppBar
import com.example.cowrywisetest.components.CurrencySelector
import com.example.cowrywisetest.components.GreenButton
import com.example.cowrywisetest.presentation.components.ClickableTextWithLink
import com.example.cowrywisetest.presentation.components.CurrencyCalculatorText
import com.example.cowrywisetest.presentation.components.GraphTypeSelector
import com.example.cowrywisetest.presentation.components.SmoothGraphWithMovableMarker
import com.example.cowrywisetest.ui.theme.CowryWiseFaintWhite
import com.example.cowrywisetest.ui.theme.CowryWiseGray
import com.example.cowrywisetest.ui.theme.CowryWiseMidBlue
import com.example.cowrywisetest.utils.GraphType
import com.example.cowrywisetest.utils.formatNumber
import com.example.cowrywisetest.utils.isValidDouble

@Composable
fun CalculatorHomeScreen(
    uiState: CurrencyCalculatorState,
    onClickSignUp: () -> Unit,
    onClickMenuIcon: () -> Unit
) {

    var convertedAmount by remember { mutableStateOf(0.00000000000) }
    var inputAmount by remember { mutableStateOf("") }

    var fromCurrency by remember { mutableStateOf("EUR") }
    var toCurrency by remember { mutableStateOf("EUR") }

    var fromCurrencyFlag by remember { mutableStateOf("🇪🇺") }
    var toCurrencyFlag by remember { mutableStateOf("🇪🇺") }

    var fromCurrencyRate by remember { mutableDoubleStateOf(1.0) }
    var toCurrencyRate by remember { mutableDoubleStateOf(1.0) }

    var triggerCompose by remember { mutableIntStateOf(1) }


    var isSwapped by remember { mutableStateOf(false) } // Track swap state

// Animate rotation angle (0° → 180° on swap)
    val rotationAngle by animateFloatAsState(
        targetValue = if (isSwapped) 360f else 0f,
        animationSpec = tween(
            durationMillis = 500,
            easing = LinearEasing
        ), // Smooth, linear rotation
        label = "rotationAnimation"
    )

    //HideSystemBars()

    LaunchedEffect(triggerCompose) {

        convertedAmount =
            if (inputAmount.isNotEmpty() && inputAmount.isValidDouble()) (inputAmount.toDouble()) * (toCurrencyRate / fromCurrencyRate) else 0.00

    }

    Scaffold(
    ) { innerPadding ->


        Box(modifier = Modifier.fillMaxSize()) {

            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .verticalScroll(rememberScrollState())
            ) {


                CowrywiseTopAppBar({}) {}

                Column(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .wrapContentHeight()
                        .fillMaxWidth()

                ) {

                    CurrencyCalculatorText()

                    Spacer(modifier = Modifier.height(8.dp))

                    CowryWiseTestTextField(
                        keyboardType = KeyboardType.Number,
                        value = inputAmount,
                        onValueChange = { value ->
                            inputAmount = value


                            convertedAmount =
                                if (inputAmount.isNotEmpty() && inputAmount.isValidDouble()) (inputAmount.toDouble()) * (toCurrencyRate / fromCurrencyRate) else 0.00
                        },
                        trailingIcon = {
                            Text(
                                fromCurrency,
                                color = Color.Gray,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.W400
                            )
                        }
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    CowryWiseTestCustomTextField(
                        value = convertedAmount.formatNumber().toString(),
                        isReadOnly = true,
                        onValueChange = { value ->
                            //convertedAmount = value
                        },
                        keyboardType = KeyboardType.Number,
                        trailingIcon = {
                            Text(
                                toCurrency,
                                color = Color.Gray,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.W400
                            )
                        }
                    )

                    //Conversion Rate
                    Row(
                        modifier = Modifier.padding(top = 4.dp),
                        horizontalArrangement = Arrangement.Start
                    ) {

                        Text(
                            text = "1 $fromCurrency",
                            color = CowryWiseMidBlue,
                            style = MaterialTheme.typography.titleSmall.copy(
                                fontWeight = FontWeight.W400,
                                fontSize = 17.sp
                            ),
                        )
                        Text(
                            text = "=",
                            color = CowryWiseMidBlue,
                            style = MaterialTheme.typography.titleSmall.copy(
                                fontWeight = FontWeight.W400,
                                fontSize = 17.sp
                            ),
                        )
                        Text(
                            text = "${(1 * (toCurrencyRate / fromCurrencyRate)).formatNumber()} $toCurrency",
                            color = CowryWiseMidBlue,
                            style = MaterialTheme.typography.titleSmall.copy(
                                fontWeight = FontWeight.W400,
                                fontSize = 17.sp
                            ),
                        )

                    }

                    Spacer(modifier = Modifier.height(30.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CurrencySelector(
                            currencyList = uiState.currencyNameWithRateList,
                            selectedCurrencyFlag = fromCurrencyFlag,
                            selectedCurrency = fromCurrency,
                            modifier = Modifier
                        ) {
                            fromCurrency = it.name
                            fromCurrencyFlag = it.flag
                            fromCurrencyRate = it.rate

                            convertedAmount =
                                if (inputAmount.isNotEmpty() && inputAmount.isValidDouble()) (inputAmount.toDouble()) * (toCurrencyRate / fromCurrencyRate) else 0.00


                        }

                        Image(
                            modifier = Modifier
                                .clickable(
                                    role = Role.Image
                                ) {
                                    isSwapped = !isSwapped
                                    // Swap logic
                                    val tempCurrency = fromCurrency
                                    val tempFlag = fromCurrencyFlag
                                    val tempRate = fromCurrencyRate

                                    fromCurrency = toCurrency
                                    fromCurrencyFlag = toCurrencyFlag
                                    fromCurrencyRate = toCurrencyRate

                                    toCurrency = tempCurrency
                                    toCurrencyFlag = tempFlag
                                    toCurrencyRate = tempRate


                                    triggerCompose++

                                }
                                .graphicsLayer {
                                    rotationZ = rotationAngle // Apply horizontal rotation effect
                                },
                            painter = painterResource(R.drawable.ic_convert),
                            contentDescription = "Image",
                            colorFilter = ColorFilter.tint(color = CowryWiseGray)
                        )

                        CurrencySelector(
                            selectedCurrency = toCurrency,
                            selectedCurrencyFlag = toCurrencyFlag,
                            currencyList = uiState.currencyNameWithRateList,
                            modifier = Modifier
                        ) {
                            toCurrency = it.name
                            toCurrencyFlag = it.flag
                            toCurrencyRate = it.rate

                            convertedAmount =
                                if (inputAmount.isNotEmpty() && inputAmount.isValidDouble()) (inputAmount.toDouble()) * (toCurrencyRate / fromCurrencyRate) else 0.00

                        }
                    }

                    Spacer(modifier = Modifier.height(40.dp))

                    GreenButton(
                        modifier = Modifier.fillMaxWidth().clickable {

                            convertedAmount =
                                if (inputAmount.isNotEmpty() && inputAmount.isValidDouble()) (inputAmount.toDouble()) * (toCurrencyRate / fromCurrencyRate) else 0.00

                        },
                        buttonText = "Convert",
                        isDisabled = false
                    )

                    ClickableTextWithLink(verticalPadding = 5.dp, showInfoIcon = true)

                }
                Spacer(modifier = Modifier.height(10.dp))

                GraphContainer()

            }
            if (uiState.isLoading) {
                CowrywiseCustomLoader {

                }
            }

        }
    }


}


@Composable
fun GraphContainer() {
    var selectedGraphOption by remember { mutableStateOf(GraphType.THIRTY_DAYS.value) }
    Box(
        modifier = Modifier
            .height(500.dp)
            .fillMaxSize()
            .background(
                color = CowryWiseMidBlue,
                shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
            )
            .clip(
                RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
            )

    ) {
        GraphTypeSelector(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
        ) {
            selectedGraphOption = it
        }

        //Market Graph
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .align(Alignment.TopCenter)
        ) {
            SmoothGraphWithMovableMarker(selectedGraphOption)
        }

        //Bottom Market Text
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(bottom = 32.dp, top = 16.dp)
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.Bottom

        ) {
            ClickableTextWithLink(
                modifier = Modifier.fillMaxWidth(),
                textColor = CowryWiseFaintWhite,
                showInfoIcon = false,
                text = "Get rate alert straight to your email inbox"
            )
        }

    }

}




