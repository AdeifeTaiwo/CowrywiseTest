package com.example.cowrywisetest.domain.usecase

import com.example.cowrywisetest.data.models.CurrencySymbolsResponse
import com.example.cowrywisetest.domain.repository.CurrencyCalculatorRepository
import com.example.cowrywisetest.utils.Resource
import kotlinx.coroutines.flow.Flow

class GetCurrencySymbols(
    private val currencyCalculatorRepository: CurrencyCalculatorRepository
) {
    suspend operator fun invoke(forceFetchRemote: Boolean): Flow<Resource<CurrencySymbolsResponse>> {
        return currencyCalculatorRepository.getCurrencySymbolsResponse(forceFetchRemote)
    }
}