package com.example.agerasimenko.demoproject.data.repository

import com.example.agerasimenko.demoproject.data.dto.CurrencyUI
import com.example.agerasimenko.demoproject.data.dto.toCurrencyUI
import com.example.agerasimenko.demoproject.data.retrofit.ApiInterface
import com.example.agerasimenko.demoproject.domain.TimeUtil
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

const val RANGE_SIZE = 20
const val USD_ID = 145

interface CurrencyRangeRepository {

    fun getRangeFromTo(startDate: String): Single<List<CurrencyUI>>

    fun getFirstRange(): Single<List<CurrencyUI>>
}

class UsdRangeRepository(private val api: ApiInterface): CurrencyRangeRepository {

    override fun getFirstRange(): Single<List<CurrencyUI>> =
        TimeUtil.getCurrentData().let(::loadRange)


    override fun getRangeFromTo(startDate: String): Single<List<CurrencyUI>> =
        loadRange(startDate)


    private fun loadRange(endDate: String) =
            TimeUtil.minusDays(endDate, RANGE_SIZE)
                    .let { startDate ->
                        api.dynamicCurrencies(USD_ID, startDate, endDate)
                                .subscribeOn(Schedulers.io())
                                .flatMap { currencies ->
                                    Observable.fromIterable(currencies)
                                            .map { it.toCurrencyUI() }
                                            .toList()
                                }
                    }
}