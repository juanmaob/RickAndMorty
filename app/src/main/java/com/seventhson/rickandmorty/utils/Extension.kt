package com.seventhson.rickandmorty.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.net.Uri
import android.provider.MediaStore
import android.view.MotionEvent
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.lazy.LazyListState
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.seventhson.rickandmorty.R

fun Context.toast(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

fun ImageView.fromUrl(url: String) {
    if (url.isNotEmpty())
        Glide.with(this).load(url).centerCrop().placeholder(R.drawable.ic_launcher_foreground)
            .into(this)
}

fun ProgressBar.show() {
    if (this.visibility == View.GONE)
        this.visibility = View.VISIBLE
}

fun ProgressBar.hide() {
    if (this.visibility == View.VISIBLE)
        this.visibility = View.GONE
}

val Int.toDp: Int get() = (this / Resources.getSystem().displayMetrics.density).toInt()

val Int.toPx: Int get() = (this * Resources.getSystem().displayMetrics.density).toInt()

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
    val fragmentTransaction = beginTransaction()
    fragmentTransaction.func()
    fragmentTransaction.commit()
}

fun AppCompatActivity.addFragment(fragment: Fragment, fragmentContainerId: Int) {
    supportFragmentManager.inTransaction { add(fragmentContainerId, fragment) }
}

fun AppCompatActivity.replaceFragment(fragment: Fragment, fragmentContainerId: Int) {
    supportFragmentManager.inTransaction { replace(fragmentContainerId, fragment) }
}

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.hide() {
    this.visibility = View.INVISIBLE
}

fun View.switchVisibility() {
    this.visibility = if (this.visibility == View.VISIBLE) View.GONE else View.VISIBLE
}

fun Activity?.showCustomMessage(text: String, timeExpose: Int) {
    if (this != null) {
        val view: View = findViewById(android.R.id.content)
        val snackbar = Snackbar.make(view, "", timeExpose)
        val layout = snackbar.view as Snackbar.SnackbarLayout
        layout.findViewById<View>(R.id.snackbar_text).visibility =
            View.INVISIBLE
        layout.setBackgroundColor(resources.getColor(android.R.color.transparent));

        val snackView: View = this.layoutInflater.inflate(R.layout.snackbar_layout, null)
        val tvSnackText = (snackView.findViewById<View>(R.id.tvSnackText) as TextView)

        if (text.isNotEmpty()) {
            tvSnackText.text = text
            tvSnackText.show()
        }

        layout.addView(snackView, 0)
        snackbar.show()
    }
}

fun Uri.getName(context: Context): String? {
    var name: String? = null
    val cursor = context.contentResolver.query(
        this,
        arrayOf(MediaStore.Files.FileColumns.DISPLAY_NAME),
        null,
        null,
        null
    )
    cursor?.let {
        if (it.moveToFirst()) {
            name = cursor.getString(0)
            cursor.close()
        }
    }
    return name

}

@SuppressLint("ClickableViewAccessibility")
fun EditText.onRightDrawableClicked(onClicked: (view: EditText) -> Unit) {
    this.setOnTouchListener { v, event ->
        var hasConsumed = false
        if (v is EditText) {
            if (event.x >= v.width - v.totalPaddingRight) {
                if (event.action == MotionEvent.ACTION_UP) {
                    onClicked(this)
                }
                hasConsumed = true
            }
        }
        hasConsumed
    }
}

fun LazyListState.isScrolledToTheEnd() = if (layoutInfo.totalItemsCount > 1)
    layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - 1
else
    false

