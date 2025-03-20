package com.example.cowrywisetest.di

import android.app.Application
import androidx.room.Room
import com.example.cowrywisetest.data.local.database.CurrencyRateDatabase
import com.example.cowrywisetest.data.remote.CurrencyCalculatorApi
import com.example.cowrywisetest.domain.repository.CurrencyCalculatorRepository
import com.example.cowrywisetest.domain.usecase.CurrencyCalculatorUseCase
import com.example.cowrywisetest.domain.usecase.GetCurrencyRates
import com.example.cowrywisetest.domain.usecase.GetCurrencySymbols
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    private val client: OkHttpClient =
        OkHttpClient().newBuilder().addInterceptor(interceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

    @Provides
    @Singleton
    fun providesMovieApi(): CurrencyCalculatorApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(CurrencyCalculatorApi.BASE_URL)
            .client(client)
            .build()
            .create(CurrencyCalculatorApi::class.java)
    }

    @Provides
    @Singleton
    fun providesMovieDatabase(application: Application): CurrencyRateDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = CurrencyRateDatabase::class.java,
            name = "currency_rate.database"
        ).fallbackToDestructiveMigration().build()
    }


    @Provides
    @Singleton
    fun providesCurrencyCalculatorUseCases(
        calculatorRepository: CurrencyCalculatorRepository,
    ): CurrencyCalculatorUseCase {
        return CurrencyCalculatorUseCase(
            getCurrencySymbols = GetCurrencySymbols(calculatorRepository),
            getCurrencyRates = GetCurrencyRates(calculatorRepository),

            )
    }
}