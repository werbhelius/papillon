package com.werb.papillon.store

import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.werb.papillon.MyApplication

/**
 * Created by wanbo on 2017/12/25.
 */
object PreferencesStore {

    private val mSharedPreferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(MyApplication.instance)


}

fun SharedPreferences.string(key: String, value: String): Boolean {
    val editor = edit()
    editor.putString(key, value)
    return editor.commit()
}

fun SharedPreferences.int(key: String, value: Int): Boolean {
    val editor = edit()
    editor.putInt(key, value)
    return editor.commit()
}