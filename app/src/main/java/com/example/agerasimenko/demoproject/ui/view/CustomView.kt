package com.example.agerasimenko.demoproject.ui.view

import android.arch.lifecycle.Observer
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.widget.RelativeLayout
import android.widget.Toast
import com.example.agerasimenko.demoproject.R
import io.reactivex.Observable
import kotlinx.android.synthetic.main.view_custom_layout.view.*


class  CustomView(context:  Context): RelativeLayout(context, null) {

    private val viewModel = CustomViewModel(Observable.just("Hello world"))
    private val dataObserver = Observer<String> { it ->
        it?.run {
            Log.d("CustomView", "observe: $it")
            some_text.text = it
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }
    }

    init {
        LayoutInflater.from(context).inflate(R.layout.view_custom_layout, this)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        viewModel.data.observeForever (dataObserver)

        Log.d("CustomView", "onAttachedToWindow")
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        Log.d("CustomView", "onDetachedFromWindow")
        viewModel.data.removeObserver (dataObserver)
    }
}