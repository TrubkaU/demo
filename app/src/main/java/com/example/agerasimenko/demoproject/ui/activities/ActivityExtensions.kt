package com.example.agerasimenko.demoproject.ui.activities

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast


fun AppCompatActivity.handleErrorMessage(errorMessage: LiveData<String>) {
    val tag = this.javaClass.canonicalName
    errorMessage.observe(this, Observer { message ->
        message?.let {
            Log.e(tag, it)
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }
    })
}