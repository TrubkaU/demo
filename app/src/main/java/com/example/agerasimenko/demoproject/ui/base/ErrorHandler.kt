package com.example.agerasimenko.demoproject.ui.base

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData


interface ErrorHandler {
    fun handleError(throwable: Throwable)

    fun getErrorMessage(): LiveData<String>
}

class ErrorHandlerImpl: ErrorHandler {

    private val errorMessage = MutableLiveData<String>()

    override fun handleError(throwable: Throwable) {
        errorMessage.value = throwable.message
    }

    override fun getErrorMessage(): LiveData<String> = errorMessage
}