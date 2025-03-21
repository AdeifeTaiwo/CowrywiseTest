package com.example.cowrywisetest.components

import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cowrywisetest.R
import com.example.cowrywisetest.data.remote.dto.CurrencyNameWithRate
import com.example.cowrywisetest.ui.theme.CowryWiseGray
import com.example.cowrywisetest.ui.theme.CowryWiseGreen
import com.example.cowrywisetest.ui.theme.SansTypography


/**
 *
 * This Composable [CurrencySelector] is used to select a currency to be converted from the list of other currency
 * @param currencyList list of currency list to be selected from
 * @param selectedCurrency selected currency from callback or default selection of "EUR"
 * @param selectedCurrencyFlag selected currency flag from callback or default selection of EUR flag
 * @param onCurrencySelected callback with return the data class [CurrencySelectionSheet] of the newly selected currency item [CurrencyNameWithRate]
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CurrencySelector(
    modifier: Modifier = Modifier,
    currencyList: List<CurrencyNameWithRate>,
    selectedCurrency: String = "EUR",
    selectedCurrencyFlag: String = "🇪🇺",
    onCurrencySelected: (CurrencyNameWithRate) -> Unit = {}
) {
    //bottom sheet
    var showBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    //currency name
    var mSelectedCurrency by remember { mutableStateOf(selectedCurrency) }
    //flag
    var mSelectedCurrencyFlag by remember { mutableStateOf(selectedCurrencyFlag) }

    Box(modifier = modifier.wrapContentWidth()) {
        Row(
            modifier = modifier
                .wrapContentWidth()
                .clip(RoundedCornerShape(4.dp))
                .border(1.dp, Color.Gray.copy(alpha = 0.3f), RoundedCornerShape(4.dp))
                .clickable { showBottomSheet = true }
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Text(
                text = selectedCurrencyFlag,
                fontWeight = FontWeight.Bold,
                color = CowryWiseGray,
                style = SansTypography.titleMedium.copy(
                    fontSize = 17.sp
                )
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = selectedCurrency,
                fontWeight = FontWeight.Bold,
                color = CowryWiseGray,
                style = SansTypography.titleMedium.copy(
                    fontSize = 17.sp
                )
            )
            Spacer(modifier = Modifier.width(8.dp))

            Icon(
                imageVector = if (showBottomSheet) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                tint = CowryWiseGray,
                contentDescription = "Dropdown"
            )
        }
    }

    if (showBottomSheet) {
        ModalBottomSheet(
            modifier = Modifier.fillMaxHeight(0.8f),
            onDismissRequest = { showBottomSheet = false },
            sheetState = sheetState,
            containerColor = Color.White,
            scrimColor = Color.Gray.copy(alpha = 0.2f)
        ) {
            CurrencySelectionSheet(currencyList) { selectedCurrency ->
                mSelectedCurrency = selectedCurrency.name
                mSelectedCurrencyFlag = selectedCurrency.flag
                onCurrencySelected(selectedCurrency)
            }
        }
    }
}


/**
 * [CurrencySelectionSheet] is a bottom to display the list of currencies and also use a callback to return the selected currency
 * @param currencyList - list of all currency name and rate
 * @param onCurrencySelected - callback with return the data class [CurrencySelectionSheet] of the newly selected currency item [CurrencyNameWithRate]
 *
 */
@Composable
fun CurrencySelectionSheet(
    currencyList: List<CurrencyNameWithRate>,
    onCurrencySelected: (CurrencyNameWithRate) -> Unit
) {
    val currencies = currencyList.toSet().map { it.name }

    var selectedCurrency by remember {
        mutableStateOf(currencies.ifEmpty { listOf("EUR") }.first())
    }

    var searchQuery by remember { mutableStateOf("") }

    val filteredCurrencyList = if (searchQuery.isBlank()) {
        currencyList.toSet().toList()
    } else {
        currencyList.filter { it.name.contains(searchQuery, ignoreCase = true) }
    }

    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize()
    ) {
        Text(
            text = stringResource(R.string.select_currency),
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        CowryWiseTestTextField(
            value = searchQuery,
            onValueChange = {
                searchQuery = it
            },
            label = stringResource(R.string.search_currencies)
        )


        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {

            if (filteredCurrencyList.isNotEmpty()) {
                items(filteredCurrencyList.toSet().toList()) { currencyNameWithRate ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                selectedCurrency = currencyNameWithRate.name
                                onCurrencySelected(currencyNameWithRate)
                            },
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = currencyNameWithRate.flag,
                            fontWeight = FontWeight.Bold,
                            color = CowryWiseGray,
                            style = SansTypography.titleMedium.copy(
                                fontSize = 17.sp
                            )
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = currencyNameWithRate.name,
                            fontSize = 17.sp,
                            color = if (selectedCurrency == currencyNameWithRate.name) CowryWiseGreen else Color.Black,
                            fontWeight = if (selectedCurrency == currencyNameWithRate.name) FontWeight.Bold else FontWeight.Normal,
                            textDecoration = if (selectedCurrency == currencyNameWithRate.name) TextDecoration.Underline else TextDecoration.None,
                            modifier = Modifier
                                .padding(vertical = 8.dp)

                        )
                    }
                }
            } else {
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 40.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = stringResource(R.string.oops_something_went_wrong),
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    }
                }
            }
        }

    }

}

