package com.example.agerasimenko.demoproject.ui.activities

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.agerasimenko.demoproject.data.dto.CurrencyUI
import com.example.agerasimenko.demoproject.data.repository.CurrencyRangeRepository
import com.example.agerasimenko.demoproject.ui.base.BaseViewModel
import com.example.agerasimenko.demoproject.ui.base.BaseViewModelFactory
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

class MainActivityViewModel(private val currencyRepository: CurrencyRangeRepository): BaseViewModel() {

    private val disposables = CompositeDisposable()
    private val uiCurrencies  =  MutableLiveData<List<CurrencyUI>>()


    fun getFirst() {
        handleRangeCurrency(currencyRepository.getFirstRange()) { newCurrencies ->
            uiCurrencies.value = newCurrencies
        }
    }

    fun getNext() {
        uiCurrencies.value?.toMutableList()?.let { currentCurrencies ->
            val lastItemDate = currentCurrencies.last().date
            handleRangeCurrency(currencyRepository.getRangeFromTo(lastItemDate)) { newCurrencies ->
                currentCurrencies.addAll(newCurrencies)
                uiCurrencies.value = currentCurrencies
            }
        }
    }

    fun getCurrencies(): LiveData<List<CurrencyUI>> = uiCurrencies

    private fun handleRangeCurrency(single: Single<List<CurrencyUI>>, onResult:(currencies: List<CurrencyUI>) -> Unit) {
        single.observeOn(AndroidSchedulers.mainThread())
                .let(::setupProgressShow)
                .subscribe(onResult, ::handleError)
                .let(disposables::add)
    }

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }
}

class MainActivityViewModelFactory (private val currencyRepository: CurrencyRangeRepository):
        BaseViewModelFactory<MainActivityViewModel>(MainActivityViewModel::class.java) {

    override fun createViewModel() = MainActivityViewModel(currencyRepository)
}