package com.example.agerasimenko.demoproject.domain

import android.app.IntentService
import android.content.Intent
import com.example.agerasimenko.demoproject.ui.activities.logd

const val NAME = "Message Service"

class MessageService : IntentService(NAME){
    override fun onHandleIntent(intent: Intent?) {
        Thread.currentThread().name.logd()


    }

    override fun onCreate() {
        super.onCreate()
        "onCreate MessageService".logd()

        Thread.currentThread().name.logd()
    }

    override fun onDestroy() {
        super.onDestroy()
        "onDestroy MessageService".logd()
    }
}