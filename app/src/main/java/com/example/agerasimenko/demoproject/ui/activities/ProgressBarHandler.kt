package com.example.agerasimenko.demoproject.ui.activities

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData


interface ProgressBarHandler {

    fun progressBarVisibility(): LiveData<Boolean>

    fun showProgressBar()

    fun hideProgressBar()
}

class ProgressBarHandlerImpl: ProgressBarHandler {

    private val visibility = MutableLiveData<Boolean>()

    override fun progressBarVisibility(): LiveData<Boolean> = visibility

    override fun showProgressBar() {
        visibility.value = true
    }

    override fun hideProgressBar() {
        visibility.value = false
    }
}