package com.example.cowrywisetest.data.remote

import com.example.cowrywisetest.data.models.CurrencyRateResponse
import com.example.cowrywisetest.data.models.CurrencySymbolsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyCalculatorApi {


    @GET("/latest")
    suspend fun getLatestCurrencyRate(
        @Query("access_key") accessKey: String = API_KEY
    ): CurrencyRateResponse


    @GET("/symbols")
    suspend fun getCurrencySymbols(
        @Query("access_key") accessKey: String = API_KEY
    ): CurrencySymbolsResponse




    companion object {
        val BASE_URL = "https://data.fixer.io/api/"
        val API_KEY = "a022745939472a62d2bbfa68496ac9af"
    }

}