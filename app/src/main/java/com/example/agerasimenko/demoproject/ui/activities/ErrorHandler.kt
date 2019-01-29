package com.example.agerasimenko.demoproject.ui.activities

import android.util.Log


interface ErrorHandler {
    fun handleError(throwable: Throwable)
}

class ErrorHandlerImpl: ErrorHandler {

    override fun handleError(throwable: Throwable) {
        Log.e("", throwable.message)
    }
}