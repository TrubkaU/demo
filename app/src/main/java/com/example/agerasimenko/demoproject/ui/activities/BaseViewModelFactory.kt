package com.example.agerasimenko.demoproject.ui.activities

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider


abstract class BaseViewModelFactory<T : ViewModel>(private val classVM: Class<T>) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        validateClass(modelClass)
        @Suppress("UNCHECKED_CAST")
        return createViewModel() as T
    }

    private fun <T : ViewModel?> validateClass(modelClass: Class<T>) {
        if (!modelClass.isAssignableFrom(classVM)) {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

    abstract fun createViewModel(): T
}