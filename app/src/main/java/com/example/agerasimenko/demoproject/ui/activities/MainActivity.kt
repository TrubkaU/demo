package com.example.agerasimenko.demoproject.ui.activities

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import com.example.agerasimenko.demoproject.R
import com.example.agerasimenko.demoproject.domain.BindService
import com.example.agerasimenko.demoproject.domain.SimpleService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val serviceConnection = object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {
            "onServiceDisconnected".logd()
        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            "onServiceConnected".logd()

            val service = (service as? BindService.LocalBinder)?.getService() ?: return

            service.getMessage().logd()
        }
    }

    private var isRun = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_run.setOnClickListener {
            runService()
        }
        button_stop.setOnClickListener {
            stop()
            if (isRun) {
                stopUnbinService()
            }
        }

        button_run_bind_service.setOnClickListener {
            isRun = bindService(Intent(this, BindService::class.java), serviceConnection, Context.BIND_AUTO_CREATE)
        }
    }

    private fun stop() {
        stopService(Intent(this, SimpleService::class.java))
    }

    private fun stopUnbinService() {
        unbindService(serviceConnection)
        isRun = false
    }

    private fun runService() {
        val intent = Intent(this, SimpleService::class.java)
        startService(intent)
    }
}
