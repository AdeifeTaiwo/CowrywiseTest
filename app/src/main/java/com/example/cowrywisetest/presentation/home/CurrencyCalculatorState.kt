package com.example.cowrywisetest.presentation.home

import com.example.cowrywisetest.data.remote.dto.CurrencyNameWithRate

data class CurrencyCalculatorState(

    val isLoading: Boolean = true,
    val currencyNameWithRateList: List<CurrencyNameWithRate> = emptyList(),
    val hasError: Boolean = false,
    val errorMessage: String = ""
)

