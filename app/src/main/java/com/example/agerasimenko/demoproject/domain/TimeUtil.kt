package com.example.agerasimenko.demoproject.domain

import java.text.SimpleDateFormat
import java.util.*


object TimeUtil {
    private const val OUT_FORMAT = "yyyy-MM-dd"

    fun getCurrentData(): String =
            Calendar.getInstance().time
                    .let(::getCurrencyData)

    fun minusDays(current: String, days: Int): String {
        return Calendar.getInstance()
                .run {
                    time = SimpleDateFormat(OUT_FORMAT, Locale.getDefault()).parse(current)
                    add(Calendar.DATE, days.inv())
                    time
                }
                .let(::getCurrencyData)
    }

    private fun getCurrencyData(date: Date) =
        SimpleDateFormat(OUT_FORMAT, Locale.getDefault())
                .format(date)
}

