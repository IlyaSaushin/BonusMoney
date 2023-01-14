package com.earl.bonusmoney.presentation.base

import android.content.Context
import android.content.SharedPreferences

class SharedPreferenceManager(context: Context) {
    private val sharedPreferences: SharedPreferences

    init {
        sharedPreferences =
            context.getSharedPreferences(Keys.KEY_PREFERENCE_NAME, Context.MODE_PRIVATE)
    }

    fun putString(key: String?, value: String?) {
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getString(key: String?): String? {
        return sharedPreferences.getString(key, null)
    }

    fun clear() {
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }
}