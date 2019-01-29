package com.example.agerasimenko.demoproject.ui.activities

import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.agerasimenko.demoproject.data.retrofit.ApiInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class MainActivityViewModel(private val aptService: ApiInterface):
        ViewModel(), ErrorHandler by ErrorHandlerImpl() {

    private val disposables = CompositeDisposable()

    fun readCurrency() {
        aptService.allCurrencies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe ({ currencies ->
                    Log.d("Currency", currencies.size.toString())
                }, ::handleError) .let(disposables::add)
    }



    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }
}

class MainActivityViewModelFactory (private val aptService: ApiInterface):
        BaseViewModelFactory<MainActivityViewModel>(MainActivityViewModel::class.java) {

    override fun createViewModel() = MainActivityViewModel(aptService)
}