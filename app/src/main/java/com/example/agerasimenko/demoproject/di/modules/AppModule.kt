package com.example.agerasimenko.demoproject.di.modules

import android.app.Application
import android.content.Context
import com.example.agerasimenko.demoproject.MainApp
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
}