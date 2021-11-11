package com.seventhson.rickandmorty.data.sharedPreferences

import android.content.Context
import javax.inject.Inject

class SharedPrefs @Inject constructor(private val context: Context) {

    companion object {

        const val SHARED_PREFERENCES = "SHARED_PREFERENCES"

    }

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)


    fun saveInShared(key: String, value: String) {
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getFromShared(key: String): String? {
        return sharedPreferences.getString(key, "")
    }

    fun saveIntInShared(key: String, value: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(key, value)
        editor.apply()
    }

    fun getIntFromShared(key: String): Int {
        return sharedPreferences.getInt(key, -1)
    }

    fun saveBooleanInShared(key: String, value: Boolean) {
        val editor = sharedPreferences.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun getBooleanFromShared(key: String): Boolean {
        return sharedPreferences.getBoolean(key, false)
    }

    fun deleteFromShared(key: String) {
        val editor = sharedPreferences.edit()
        editor.remove(key)
        editor.apply()
    }

    fun deleteAllSharedPrefs() {
        sharedPreferences.edit().clear().apply()
    }


}