package com.bayutb.core.utils

import java.text.NumberFormat
import java.util.Currency

fun convertToCurrency(input: Int) : String {
    val format = NumberFormat.getCurrencyInstance()
    format.minimumFractionDigits = 0
    format.currency = Currency.getInstance("USD")
    return format.format(input.toDouble()).replace("$", "$ ")
}