package com.example.cowrywisetest.di

import com.example.alatapp.welcomescreen.data.repository.CurrencyCalculatorRepositoryImpl
import com.example.cowrywisetest.domain.repository.CurrencyCalculatorRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCurrencyCalculatorRepository(
        currencyCalculatorRepositoryImpl: CurrencyCalculatorRepositoryImpl
    ) : CurrencyCalculatorRepository
}