package com.example.agerasimenko.demoproject.data.retrofit

import com.example.agerasimenko.demoproject.data.dto.Currency
import com.example.agerasimenko.demoproject.data.dto.RangeCurrency
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val ID = "id"
const val START_DATE = "startDate"
const val END_DATE = "endDate"

interface ApiInterface {

    @GET("Currencies")
    fun allCurrencies(): Single<List<Currency>>

    @GET("Rates/Dynamics/{$ID}")
    fun dynamicCurrencies(
            @Path(ID) currencyId: Int,
            @Query(START_DATE) startDate: String,
            @Query(END_DATE) endDate: String
    ): Single<List<RangeCurrency>>

}