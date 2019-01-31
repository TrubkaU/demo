package com.example.agerasimenko.demoproject.ui.activities

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.agerasimenko.demoproject.data.dto.CurrencyUI
import com.example.agerasimenko.demoproject.data.repository.CurrencyRangeRepository
import com.example.agerasimenko.demoproject.ui.base.BaseViewModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

class MainActivityViewModel(private val currencyRepository: CurrencyRangeRepository): BaseViewModel() {

    private val disposables = CompositeDisposable()
    private val uiCurrencies  =  MutableLiveData<List<CurrencyUI>>()


    fun getFirst() {
        handleRangeCurrency(currencyRepository.getFirstRange())
    }

    fun getNext() {
        uiCurrencies.value?.last()?.date
                ?.let {
                    handleRangeCurrency(currencyRepository.getRangeFromTo(it))
                }
    }

    fun getCurrencies(): LiveData<List<CurrencyUI>> = uiCurrencies

    private fun handleRangeCurrency(single: Single<List<CurrencyUI>>, onResult:(currencies: List<CurrencyUI>) -> Unit) {
        single.observeOn(AndroidSchedulers.mainThread())
                .let(::setupProgressShow)
                .subscribe(onResult, ::handleError)
                .let(disposables::add)
    }

    private fun handleCurrencyResult(currencies: List<CurrencyUI>) {
        (uiCurrencies.value
                ?.toMutableList()
                ?.apply { addAll(currencies) }
                ?: currencies)
                .let(uiCurrencies::setValue)
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