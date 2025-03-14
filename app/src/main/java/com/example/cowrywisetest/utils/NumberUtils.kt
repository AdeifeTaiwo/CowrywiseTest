package com.example.cowrywisetest.utils

import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.Locale

fun Double.formatNumber(): String {
    val formatter = DecimalFormat("#.######") // Adjust decimal places as needed
    return formatter.format(this)
}

/**
 * Converts to full string without scientific notation
 */
fun Double.formatNumberToBigDecimal(): String {
    return BigDecimal(this).toPlainString()
}

fun String?.isValidDouble(): Boolean {
    if (this.isNullOrBlank()) return false  // Reject empty/null input

    val cleanedInput = this.replace(",", ".") // Normalize decimal separator

    // Reject if it starts or ends with a dot, or has multiple dots
    if (cleanedInput.startsWith(".") || cleanedInput.endsWith(".") || cleanedInput.count { it == '.' } > 1) {
        return false
    }

    // Regex: Allows numbers with an optional single decimal point in the correct place
    return cleanedInput.matches(Regex("^-?\\d+(\\.\\d+)?\$"))
}


fun Double.toSignificantFigures(sigFigures: Int = 3): String {
    if (this == 0.0) return "0"

    val scale = Math.pow(10.0, (sigFigures - 1 - Math.floor(Math.log10(kotlin.math.abs(this)))).toDouble())
    val roundedValue = kotlin.math.round(this * scale) / scale

    // Convert to string without scientific notation
    return String.format(Locale.US, "%.10f", roundedValue).trimEnd('0').trimEnd('.')
}
