package com.example.agerasimenko.demoproject.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.agerasimenko.demoproject.R
import com.example.agerasimenko.demoproject.ui.view.CustomView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_close.setOnClickListener {
            custom_view_container.removeAllViews()
        }

        button_show.setOnClickListener {
            custom_view_container.addView(CustomView(this))
        }
    }
}
