package com.example.cowrywisetest.domain.usecase

data class CurrencyCalcUseCase(
    val getCurrencyRates: GetCurrencyRates,
    val getCurrencySymbols: GetCurrencySymbols
)