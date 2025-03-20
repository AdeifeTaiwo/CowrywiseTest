package com.example.cowrywisetest.domain.usecase

data class CurrencyCalculatorUseCase(
    val getCurrencyRates: GetCurrencyRates,
    val getCurrencySymbols: GetCurrencySymbols
)