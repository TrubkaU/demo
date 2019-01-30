package com.example.agerasimenko.demoproject.ui.activities.adapter

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.agerasimenko.demoproject.R
import com.example.agerasimenko.demoproject.data.dto.CurrencyUI
import kotlinx.android.synthetic.main.item_currency.view.*


class CurrencyAdapter: ListAdapter<CurrencyUI, CurrencyHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): CurrencyHolder {
        return LayoutInflater.from(parent.context)
                .inflate(R.layout.item_currency, parent, false)
                .run { CurrencyHolder(this) }
    }

    override fun onBindViewHolder(holder: CurrencyHolder, position: Int) {
        getItem(position)?.let(holder::bind)
    }

    companion object {
        private val DIFF_CALLBACK = object :
                DiffUtil.ItemCallback<CurrencyUI>() {
            override fun areItemsTheSame(oldItem: CurrencyUI, newItem: CurrencyUI) =
                    oldItem.date == newItem.date && oldItem.rate == newItem.rate

            override fun areContentsTheSame(oldItem: CurrencyUI, newItem: CurrencyUI) =
                    oldItem == newItem
        }
    }
}


class CurrencyHolder(v: View): RecyclerView.ViewHolder(v) {

    fun bind(currency: CurrencyUI) {
        itemView.name.text = currency.date
        itemView.scale.text = currency.rate.toString()
    }
}