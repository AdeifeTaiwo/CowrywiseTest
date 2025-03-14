package com.example.cowrywisetest.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [CurrencyNameWithRateEntity::class],
    version = 1,
    exportSchema = false
)

abstract class CurrencyRateDatabase : RoomDatabase() {
    abstract val currencyRateDao: CurrencyRateDao
}