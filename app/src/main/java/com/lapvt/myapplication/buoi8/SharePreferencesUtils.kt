package com.lapvt.myapplication.buoi8

import android.content.Context

object SharePreferencesUtils {
    fun saveName(name: String, context: Context) {
        // Lệnh lấy preferences bằng context
        val preferences = context.getSharedPreferences("abc", Context.MODE_PRIVATE)
        // Lưu dữ liệu string bằng key "name"
        preferences.edit().putString("name", name).apply()
    }

    fun getName(context: Context): String {
        // Lệnh lấy preferences bằng context
        val preferences = context.getSharedPreferences("abc", Context.MODE_PRIVATE)
        // Lấy dữ liệu
        return preferences.getString("name", "") ?: ""
    }
}