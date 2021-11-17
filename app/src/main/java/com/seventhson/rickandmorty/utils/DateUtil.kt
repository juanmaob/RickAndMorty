package com.seventhson.rickandmorty.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class DateUtil {
    companion object {
        private val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        const val DAY_NUMDAY_MONTH = "EEEE, d MMMM"

    }

    fun stringToDate(stringDate: String, format: String) : Date? {
        val formatterTo = SimpleDateFormat(format, Locale.getDefault())
        return try {
            formatterTo.parse(stringDate)
        } catch (parseException: ParseException) {
            null
        }
    }

    fun formatDateFrom(stringDate: String, formatFrom: String, formatTo: String): String {
        if (stringDate.isBlank()) return ""
        return try {
            val formatterTo = SimpleDateFormat(formatTo, Locale.getDefault())
            val formatterFrom = SimpleDateFormat(formatFrom, Locale.getDefault())
            formatterTo.format(formatterFrom.parse(stringDate))
        } catch (e: Exception) {
            ""
        }
    }


}


