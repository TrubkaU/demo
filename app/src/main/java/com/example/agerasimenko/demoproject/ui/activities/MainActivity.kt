package com.example.agerasimenko.demoproject.ui.activities

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.agerasimenko.demoproject.MainApp
import com.example.agerasimenko.demoproject.R
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: MainActivityViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as MainApp).getApplicationComponent().inject(this)

        getViewModel().let { viewModel ->
            read.setOnClickListener {
                viewModel.readCurrency()
            }
        }
    }

    private fun getViewModel() =
            ViewModelProviders.of(this, factory).get(MainActivityViewModel::class.java)
}
