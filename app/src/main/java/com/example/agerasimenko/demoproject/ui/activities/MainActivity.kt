package com.example.agerasimenko.demoproject.ui.activities

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.agerasimenko.demoproject.MainApp
import com.example.agerasimenko.demoproject.R
import com.example.agerasimenko.demoproject.data.dto.CurrencyUI
import com.example.agerasimenko.demoproject.ui.activities.adapter.CurrencyAdapter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: MainActivityViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initCurrencyList()

        (application as MainApp).getApplicationComponent().inject(this)

        getViewModel().let { viewModel ->
            currencySwipe.setOnRefreshListener {
                viewModel.getFirst()
            }
            viewModel.getFirst()
        }
    }

    private fun initCurrencyList() {
        currencyList.run {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = CurrencyAdapter()
        }
    }

    private fun setCurrenciesToList(currencies: List<CurrencyUI>?) {
        currencies?.let {
            currencySwipe.isRefreshing = false
            (currencyList.adapter as CurrencyAdapter).submitList(it)
        }
    }

    private fun getViewModel() =
            ViewModelProviders.of(this, factory)
                    .get(MainActivityViewModel::class.java)
                    .apply {
                        getCurrencies().observe(this@MainActivity, Observer(::setCurrenciesToList))
                        handleErrorMessage(getErrorMessage())
                    }
}