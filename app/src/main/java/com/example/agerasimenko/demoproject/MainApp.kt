package com.example.agerasimenko.demoproject

import android.app.Application
import com.example.agerasimenko.demoproject.di.modules.AppModule
import com.example.agerasimenko.demoproject.di.components.ApplicationComponent
import com.example.agerasimenko.demoproject.di.DaggerApplicationComponent


class MainApp: Application() {

    private lateinit var appComponent: ApplicationComponent


    override fun onCreate() {
        super.onCreate()
        initAppComponent()
    }

    private fun initAppComponent() {
        appComponent = DaggerApplicationComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    fun getApplicationComponent() = appComponent
}