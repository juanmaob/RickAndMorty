package com.seventhson.rickandmorty.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.ImageView
import androidx.core.app.ActivityOptionsCompat
import com.seventhson.rickandmorty.ui.common.BaseComposeActivity
import com.seventhson.rickandmorty.ui.detail.DetailActivity
import com.seventhson.rickandmorty.ui.main.MainActivity

class Navigator {

    companion object {
        const val CHARACTER_ID = "CHARACTER_ID"
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

    fun goToDetail(
        context: Context,
        characterId: Int,
        image: ImageView?
    ) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra(CHARACTER_ID, characterId)
        image?.let {
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(context as BaseComposeActivity, image, "detailTransition")
            navigate(context, intent, options)
        }
        navigate(context, intent)

    }


}