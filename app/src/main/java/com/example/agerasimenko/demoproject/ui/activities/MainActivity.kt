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
import com.example.agerasimenko.demoproject.ui.activities.adapter.EndScrollListener
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: MainActivityViewModelFactory

    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as MainApp).getApplicationComponent().inject(this)

        initCurrencyList()

        viewModel = getViewModel()
    }

    private fun initCurrencyList() {
        currencyList.run {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = CurrencyAdapter()

            currencySwipe.setOnRefreshListener {
                viewModel.getFirst()
            }
            addOnScrollListener(EndScrollListener(layoutManager as LinearLayoutManager) {
                viewModel.getNext()
            })
        }
    }

    private fun setCurrenciesToList(currencies: List<CurrencyUI>?) {
        currencies?.let {
            (currencyList.adapter as CurrencyAdapter).submitList(it)
        }
    }

    private fun getViewModel() =
            ViewModelProviders.of(this, factory)
                    .get(MainActivityViewModel::class.java)
                    .apply {
                        getCurrencies().observe(this@MainActivity, Observer(::setCurrenciesToList))
                        progressBarVisibility().observe(this@MainActivity, Observer {
                            it?.let(::setProgressBarVisible)
                        })
                        getFirst()
                        handleErrorMessage(getErrorMessage())
                    }

    private fun setProgressBarVisible(visibility: Boolean) {
        currencySwipe.isRefreshing = visibility
    }
}