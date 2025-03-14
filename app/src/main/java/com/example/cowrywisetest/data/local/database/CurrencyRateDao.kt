package com.example.cowrywisetest.data.local.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert


@Dao
interface CurrencyRateDao {
    //if its not there insert,
    // if its there update it
    @Upsert
    suspend fun upsertAllCurrencyRate(currencyName: List<CurrencyNameWithRateEntity>)


    @Query("SELECT * FROM currency_rates  ORDER BY name ASC")
    suspend fun getAllCurrencyRate() : List<CurrencyNameWithRateEntity>


}