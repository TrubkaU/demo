package com.example.agerasimenko.demoproject.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.agerasimenko.demoproject.MainApp
import com.example.agerasimenko.demoproject.R
import com.example.agerasimenko.demoproject.data.retrofit.ApiInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var aptService: ApiInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as MainApp).getApplicationComponent().inject(this)

        read.setOnClickListener {
            aptService.allCurrencies()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe { currencies ->
                Log.d("Currency", currencies.size.toString())
            }
        }
    }
}
