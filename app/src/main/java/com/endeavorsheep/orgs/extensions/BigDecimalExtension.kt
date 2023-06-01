package com.endeavorsheep.orgs.extensions

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Locale

fun BigDecimal.formatPrice(): String {
    val format: NumberFormat = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
    return format.format(this)
}