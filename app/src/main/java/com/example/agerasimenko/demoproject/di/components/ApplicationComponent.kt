package com.example.agerasimenko.demoproject.di.components

import com.example.agerasimenko.demoproject.MainApp
import com.example.agerasimenko.demoproject.di.modules.AppModule
import com.example.agerasimenko.demoproject.di.modules.NetworkModule
import com.example.agerasimenko.demoproject.ui.activities.MainActivity
import dagger.Component
import javax.inject.Singleton


@Component(modules = [AppModule::class, NetworkModule::class])
@Singleton
interface ApplicationComponent {
    fun inject(app: MainApp)

    fun inject(activity: MainActivity)
}