package com.example.agerasimenko.demoproject.ui.activities.adapter

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

const val TIMEOUT_FOR_SCROLL_IN_MS = 500

class EndScrollListener(private val layoutManager: LinearLayoutManager,
                         private val onDownList: () -> Unit)
    : RecyclerView.OnScrollListener() {

    private var lastCallOnDownList: Long = 0L

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        if (dy == 0) {
            return
        }
        val visibleItemCount = layoutManager.childCount
        val totalItemCount = layoutManager.itemCount
        val first = layoutManager.findFirstVisibleItemPosition()
        if (first + visibleItemCount >= totalItemCount
                && System.currentTimeMillis() > TIMEOUT_FOR_SCROLL_IN_MS + lastCallOnDownList) {
            lastCallOnDownList = System.currentTimeMillis()
            onDownList()
        }
    }
}
