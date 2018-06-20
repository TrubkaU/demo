package com.example.agerasimenko.demoproject.ui.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.agerasimenko.demoproject.R
import com.example.agerasimenko.demoproject.domain.SimpleService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_run.setOnClickListener {
            runService()
        }
        button_stop.setOnClickListener {
            stop()
        }
    }

    private fun stop() {
        stopService(Intent(this, SimpleService::class.java))
    }

    private fun runService() {
        val intent = Intent(this, SimpleService::class.java)
        startService(intent)
    }
}
