package com.seventhson.rickandmorty.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.core.app.ActivityOptionsCompat
import com.seventhson.rickandmorty.ui.common.BaseComposeActivity
import com.seventhson.rickandmorty.ui.main.MainActivity

class Navigator {

    companion object {
        const val CHARACTER_ID = "CHARACTER_ID"
        const val NAME_ID = "NAME_ID"
        const val PICTURE_ID = "PICTURE_ID"
    }

    private fun navigate(context: Context, intent: Intent?, options: ActivityOptionsCompat) {
        (context as BaseComposeActivity).startActivity(intent, options.toBundle())
    }

    private fun navigate(context: Context, intent: Intent?) {
        (context as Activity).startActivity(intent)
    }

    fun goToMain(context: Context) {
        val intent = Intent(context, MainActivity::class.java)
        navigate(context, intent)
    }

    /*fun goToDetail(
        context: Context,
        characterId: Int,
        characterName: String,
        characterPicture: String,
        image: ImageView?
    ) {
        val intent = Intent(context, DetailActivity::class.java).apply {
            putExtra(CHARACTER_ID, characterId)
            putExtra(NAME_ID, characterName)
            putExtra(PICTURE_ID, characterPicture)
        }

        image?.let {
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(context as BaseComposeActivity, image, "detailTransition")
            navigate(context, intent, options)
        }

        navigate(context, intent)
    }*/



}