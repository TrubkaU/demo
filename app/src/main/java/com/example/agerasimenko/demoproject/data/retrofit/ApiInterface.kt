package com.example.agerasimenko.demoproject.data.retrofit

import com.example.agerasimenko.demoproject.data.dto.Currency
import io.reactivex.Single
import retrofit2.http.GET


interface ApiInterface {

    @GET("Currencies")
    fun allCurrencies(): Single<List<Currency>>
}