package com.example.agerasimenko.demoproject.domain

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import com.example.agerasimenko.demoproject.ui.activities.logd


class BindService: Service() {

    private val iBinder = LocalBinder()

    override fun onBind(intent: Intent?): IBinder = iBinder

    override fun onCreate() {
        super.onCreate()
        "onCreate BindService".logd()
    }

    override fun onDestroy() {
        super.onDestroy()
        "onDestroy BindService".logd()
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        "onStartCommand  BindService".logd()
        return super.onStartCommand(intent, flags, startId)
    }

    fun getMessage() = "Service ready to use"

    internal inner class LocalBinder: Binder() {
        fun getService() : BindService {
            return this@BindService
        }
    }
}