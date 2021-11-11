package com.seventhson.rickandmorty.utils

import android.app.Activity
import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.text.format.DateFormat
import android.view.Window
import com.seventhson.rickandmorty.R
import java.util.*

class DialogUtil {

    fun getLoadingDialog(
        activity: Context
    ) : Dialog {

        val dialog = Dialog(activity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.loading_layout)
        return dialog
    }

    fun showDatePicker(
        context: Context
        , onDateSet: (date: String) -> Unit
    ) {
        val calendar: Calendar = Calendar.getInstance()
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val month = calendar.get(Calendar.MONTH)
        val year = calendar.get(Calendar.YEAR)
        val datePickerDialog = DatePickerDialog(
            context,
            { datePicker, year, month, day ->
                val dateSelected = "$day/${month + 1}/$year"
                onDateSet(dateSelected)
            }, year, month, day
        )
        datePickerDialog.datePicker.maxDate = System.currentTimeMillis()
        datePickerDialog.show()
    }

}