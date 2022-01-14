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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
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

fun Modifier.drawColoredShadow(
    color: Color,
    alpha: Float = 0.2f,
    borderRadius: Dp = 0.dp,
    shadowRadius: Dp = 20.dp,
    offsetY: Dp = 0.dp,
    offsetX: Dp = 0.dp
) = this.drawBehind {
    val transparentColor = android.graphics.Color.toArgb(color.copy(alpha = 0.0f).value.toLong())
    val shadowColor = android.graphics.Color.toArgb(color.copy(alpha = alpha).value.toLong())

    this.drawIntoCanvas {
        val paint = Paint()
        val frameworkPaint = paint.asFrameworkPaint()
        frameworkPaint.color = transparentColor
        frameworkPaint.setShadowLayer(
            shadowRadius.toPx(),
            offsetX.toPx(),
            offsetY.toPx(),
            shadowColor
        )
        it.drawRoundRect(
            left = 0f,
            top = 0f,
            right = this.size.width,
            bottom = this.size.height,
            radiusX = borderRadius.toPx(),
            radiusY = borderRadius.toPx(),
            paint = paint
        )
    }
}