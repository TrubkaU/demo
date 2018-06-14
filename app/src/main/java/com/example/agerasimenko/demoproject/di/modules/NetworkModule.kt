package com.example.agerasimenko.demoproject.di.modules

import com.example.agerasimenko.demoproject.BuildConfig
import com.example.agerasimenko.demoproject.data.retrofit.AuthInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

const val URL = "http://tut.by"

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideHttpClient() =
            OkHttpClient.Builder().apply {
                if (BuildConfig.DEBUG) {
                    addInterceptor(HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT).apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    })
                }
            }
                    .addInterceptor(AuthInterceptor())
                    .build()


    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient) =
            Retrofit.Builder()
                    .baseUrl(URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()

}