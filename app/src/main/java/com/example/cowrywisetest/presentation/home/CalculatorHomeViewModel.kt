package com.example.cowrywisetest.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cowrywisetest.domain.usecase.CurrencyCalculatorUseCase
import com.example.cowrywisetest.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class  CalculatorHomeViewModel @Inject constructor(
    private val currencyCalculatorUseCase: CurrencyCalculatorUseCase
) : ViewModel() {

    private var _currencyCalculatorState = MutableStateFlow(CurrencyCalculatorState())
    val countryListState = _currencyCalculatorState.asStateFlow()

    init {
        initCurrencyRateList()
    }

    private fun initCurrencyRateList() {
        viewModelScope.launch {
            currencyCalculatorUseCase.getCurrencyRates(forceFetchRemote = true)
                .collectLatest { result ->
                    when (result) {
                        is Resource.Success -> {
                            result.data.let { currencyRateList ->
                                _currencyCalculatorState.update {
                                    it.copy(
                                        isLoading = false,
                                        currencyNameWithRateList = currencyRateList?: emptyList(),
                                    )
                                }
                            }
                        }

                        is Resource.Error -> {
                            _currencyCalculatorState.update {
                                it.copy(
                                    isLoading = false,
                                    hasError = true,
                                    errorMessage = it.errorMessage
                                )
                            }
                        }

                        is Resource.Loading -> {
                            _currencyCalculatorState.update {
                                it.copy(
                                    isLoading = true,
                                    hasError = false,
                                    errorMessage = ""
                                )
                            }
                        }

                    }
                }
        }
    }
}