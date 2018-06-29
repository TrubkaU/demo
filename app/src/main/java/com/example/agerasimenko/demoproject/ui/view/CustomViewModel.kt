package com.example.agerasimenko.demoproject.ui.view

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.LiveDataReactiveStreams
import android.arch.lifecycle.ViewModel
import android.util.Log
import io.reactivex.BackpressureStrategy
import io.reactivex.Observable


class CustomViewModel(val text: Observable<String>): ViewModel() {

    val data: LiveData<String>

    init {
        Log.d("CustomView", "Create ViewModel")

        val publisher = text.toFlowable(BackpressureStrategy.LATEST)
        data = LiveDataReactiveStreams.fromPublisher(publisher)
    }
}