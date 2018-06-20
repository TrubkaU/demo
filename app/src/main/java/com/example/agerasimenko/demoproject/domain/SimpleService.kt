package com.example.agerasimenko.demoproject.domain

import android.app.Service
import android.content.Intent
import com.example.agerasimenko.demoproject.ui.activities.logd


class SimpleService: Service() {

    override fun onBind(intent: Intent?) = null


    override fun onCreate() {
        super.onCreate()
        "onCreate".logd()
    }

    override fun onDestroy() {
        super.onDestroy()
        "onDestroy".logd()
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        "onStartCommand".logd()
        return super.onStartCommand(intent, flags, startId)
    }
}