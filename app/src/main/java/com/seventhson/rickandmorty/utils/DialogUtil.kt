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
        activity: Activity
    ) : Dialog {

        val dialog = Dialog(activity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.loading_layout)
        return dialog
    }

}