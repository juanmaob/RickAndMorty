package com.seventhson.rickandmorty.utils

import android.graphics.Bitmap
import android.util.Log
import androidx.compose.ui.graphics.Color
import androidx.palette.graphics.Palette
import coil.bitmap.BitmapPool
import coil.size.Size
import coil.transform.Transformation

class PaletteTransformation(
    private val onPaletteAvailable: (PaletteColors) -> Unit
) : Transformation {

    data class PaletteColors(
        val dominant: Color,
        val vibrant: Color,
        val lightVibrant: Color,
        val darkVibrant: Color,
        val muted: Color,
        val lightMuted: Color,
        val darkMuted: Color
    )

    override fun key(): String = PaletteTransformation::class.java.name

    override suspend fun transform(pool: BitmapPool, input: Bitmap, size: Size): Bitmap {
        val start = System.currentTimeMillis()

        val palette = Palette.from(input).generate()
        val postpalette = System.currentTimeMillis()
        Log.d("PALETTE", "Palette builder: " + (postpalette-start).toString())


        onPaletteAvailable(
            PaletteColors(
                dominant = Color(palette.getDominantColor(0)),
                vibrant = Color(palette.getVibrantColor(0)),
                lightVibrant = Color(palette.getLightVibrantColor(0)),
                darkVibrant = Color(palette.getDarkVibrantColor(0)),
                muted = Color(palette.getMutedColor(0)),
                lightMuted = Color(palette.getLightMutedColor(0)),
                darkMuted = Color(palette.getDarkMutedColor(0)),
            )
        )


        val end = System.currentTimeMillis()
        Log.d("PALETTE", "Post colors: " + (end-postpalette).toString())

        return input
    }

    override fun equals(other: Any?) = other is PaletteTransformation

    override fun hashCode() = javaClass.hashCode()

    override fun toString() = "PaletteTransformation()"
}