package com.example.cowrywisetest.domain.repository

import com.example.cowrywisetest.data.models.CurrencySymbolsResponse
import com.example.cowrywisetest.data.remote.dto.CurrencyNameWithRate
import com.example.cowrywisetest.utils.Resource
import kotlinx.coroutines.flow.Flow

interface CurrencyCalculatorRepository {

    suspend fun getLatestCurrencyRateResponse(
        forceFetchFromRemote: Boolean
    ): Flow<Resource<List<CurrencyNameWithRate>>>

    suspend fun getCurrencySymbolsResponse(  forceFetchFromRemote: Boolean
    ): Flow<Resource<CurrencySymbolsResponse>>


}