package com.example.agerasimenko.demoproject.ui.base

import android.arch.lifecycle.ViewModel
import com.example.agerasimenko.demoproject.ui.activities.ErrorHandler
import com.example.agerasimenko.demoproject.ui.activities.ErrorHandlerImpl
import com.example.agerasimenko.demoproject.ui.activities.ProgressBarHandler
import com.example.agerasimenko.demoproject.ui.activities.ProgressBarHandlerImpl
import io.reactivex.Single


abstract class BaseViewModel:  ViewModel(),
        ErrorHandler by ErrorHandlerImpl(),
        ProgressBarHandler by ProgressBarHandlerImpl() {

    protected inline fun <T> setupProgressShow(single: Single<T>): Single<T> {
        return single.doOnSubscribe { showProgressBar() }
                .doOnSuccess { hideProgressBar() }
                .doOnError { hideProgressBar() }
                .doOnDispose { hideProgressBar() }
    }
}