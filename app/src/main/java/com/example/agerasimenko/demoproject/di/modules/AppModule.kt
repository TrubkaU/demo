package com.example.agerasimenko.demoproject.di.modules

import android.app.Application
import android.content.Context
import com.example.agerasimenko.demoproject.MainApp
import com.example.agerasimenko.demoproject.data.repository.UsdRangeRepository
import com.example.agerasimenko.demoproject.data.retrofit.ApiInterface
import com.example.agerasimenko.demoproject.ui.activities.MainActivityViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: Application) {

    @Provides
    @Singleton
    fun provideApp():  Application = app

    @Provides
    @Singleton
    fun provideAppContext(app: MainApp): Context = app

    @Provides
    fun provideUsdRangeRepository(api: ApiInterface) = UsdRangeRepository(api)

    @Provides
    fun provideMainActivityViewModelFactory(currencyRepository: UsdRangeRepository) =
            MainActivityViewModelFactory(currencyRepository)
}