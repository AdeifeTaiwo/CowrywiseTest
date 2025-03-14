package com.example.cowrywisetest.domain.usecase

import com.example.cowrywisetest.data.remote.dto.CurrencyNameWithRate
import com.example.cowrywisetest.domain.repository.CurrencyCalculatorRepository
import com.example.cowrywisetest.utils.Resource
import kotlinx.coroutines.flow.Flow

class GetCurrencyRates(
    private val currencyCalculatorRepository: CurrencyCalculatorRepository
) {
    suspend operator fun invoke(forceFetchRemote:Boolean):  Flow<Resource<List<CurrencyNameWithRate>>> {
        return currencyCalculatorRepository.getLatestCurrencyRateResponse(forceFetchRemote)
    }
}