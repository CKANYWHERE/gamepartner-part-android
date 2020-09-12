package com.example.game_partner.SharedPreferences

import android.content.Context
import android.content.SharedPreferences

class PreferenceUtil(context: Context) {
    val prefs: SharedPreferences =
        context.getSharedPreferences("prefs_name", Context.MODE_PRIVATE)

    fun getString(key: String, defValue: String): String {
        return prefs.getString(key, defValue).toString()
    }
    fun setString(key: String, str: String) {
        prefs.edit().putString(key, str).apply()
    }

    fun getInt(key: String, defValue: Int): Int {
        return prefs.getInt(key, defValue).toInt()
    }

    fun setInt(key: String, int:Int) {
        prefs.edit().putInt(key, int).apply()
    }

    fun getLong(key:String, defValue: Long): Long{
        return prefs.getLong(key, defValue).toLong()
    }

    fun setLong(key: String, long:Long) {
        prefs.edit().putLong(key, long).apply()
    }
}
