package com.example.cowrywisetest.data.local.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "currency_rates")
data class CurrencyNameWithRateEntity(
    @PrimaryKey val name: String,
    val rate: Double,
    val flag: String = ""
)


