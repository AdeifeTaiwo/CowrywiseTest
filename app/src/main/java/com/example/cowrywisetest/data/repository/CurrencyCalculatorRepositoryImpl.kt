package com.example.alatapp.welcomescreen.data.repository

import com.example.cowrywisetest.data.local.database.CurrencyRateDatabase
import com.example.cowrywisetest.data.mapper.MapRatesToCurrencyRateWithNameList
import com.example.cowrywisetest.data.mapper.mapRatesToCurrencyListEntity
import com.example.cowrywisetest.data.mapper.toCurrencyNameWithRateItem
import com.example.cowrywisetest.data.models.CurrencySymbolsResponse
import com.example.cowrywisetest.data.remote.CurrencyCalculatorApi
import com.example.cowrywisetest.data.remote.dto.CurrencyNameWithRate
import com.example.cowrywisetest.domain.repository.CurrencyCalculatorRepository
import com.example.cowrywisetest.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CurrencyCalculatorRepositoryImpl @Inject constructor(
    private val currencyCalculatorApi: CurrencyCalculatorApi,
    private val currencyRateDatabase: CurrencyRateDatabase
) : CurrencyCalculatorRepository {

    override suspend fun getLatestCurrencyRateResponse(forceFetchFromRemote: Boolean): Flow<Resource<List<CurrencyNameWithRate>>> {
        return flow {
            emit(Resource.Loading(true))
            val localCurrencyRateList = currencyRateDatabase.currencyRateDao.getAllCurrencyRate()

            val shouldLoadMovieLocally = localCurrencyRateList.isNotEmpty() && !forceFetchFromRemote

            if (shouldLoadMovieLocally) {
                emit(Resource.Success(data = localCurrencyRateList.map { entity ->
                    entity.toCurrencyNameWithRateItem()
                }))
                emit(Resource.Loading(false))
                return@flow
            }

            else {
                val countryCodeAndFlagListFromRemote = try {

                    emit(Resource.Loading(true))

                    val currencyRateEntities = currencyCalculatorApi.getLatestCurrencyRate().rates?.let {
                        mapRatesToCurrencyListEntity(it)
                    }

                    //save to database
                    currencyRateEntities?.let {
                        currencyRateDatabase.currencyRateDao.upsertAllCurrencyRate(
                            it
                        )
                    }

                    emit(Resource.Success(MapRatesToCurrencyRateWithNameList(currencyCalculatorApi.getLatestCurrencyRate().rates)))

                    val localUpdatedCurrencyRateList = currencyRateDatabase.currencyRateDao.getAllCurrencyRate()

                    emit(Resource.Success(data = localUpdatedCurrencyRateList.map { entity ->
                        entity.toCurrencyNameWithRateItem()
                    }))




                } catch (e: HttpException) {
                    e.printStackTrace()

                    val localUpdatedCurrencyRateList = currencyRateDatabase.currencyRateDao.getAllCurrencyRate()
                    if(localUpdatedCurrencyRateList.isNotEmpty()) {
                        emit(Resource.Success(data = localUpdatedCurrencyRateList.map { entity ->
                            entity.toCurrencyNameWithRateItem()
                        }))
                    } else {
                        emit(Resource.Error(message = "Please Check your internet"))
                    }
                    e.response()?.errorBody()

                } catch (e: IOException) {
                    e.printStackTrace()
                    val localUpdatedCurrencyRateList = currencyRateDatabase.currencyRateDao.getAllCurrencyRate()

                    if(localUpdatedCurrencyRateList.isNotEmpty()) {
                        emit(Resource.Success(data = localUpdatedCurrencyRateList.map { entity ->
                            entity.toCurrencyNameWithRateItem()
                        }))
                    }else {
                        emit(Resource.Error(message = "Error Currency Rate"))
                    }

                } catch (e: Exception) {
                    e.printStackTrace()
                    val localUpdatedCurrencyRateList = currencyRateDatabase.currencyRateDao.getAllCurrencyRate()
                    if(localUpdatedCurrencyRateList.isNotEmpty()) {
                        emit(Resource.Success(data = localUpdatedCurrencyRateList.map { entity ->
                            entity.toCurrencyNameWithRateItem()
                        }))
                    }else {
                        emit(Resource.Error(message = "Error Loading Currency Rate"))
                    }

                }

                return@flow
            }
        }
    }

    override suspend fun getCurrencySymbolsResponse(forceFetchFromRemote: Boolean): Flow<Resource<CurrencySymbolsResponse>> {
        TODO("Not yet implemented")
    }




}