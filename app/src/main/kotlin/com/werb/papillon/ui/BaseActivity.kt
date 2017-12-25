package com.werb.papillon.ui

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

/**
 * BaseActivity to set something common
 * Created by wanbo on 2017/12/25.
 */
open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (!dealStatusBarDefault()) fullTheme()
    }

    /** fullscreen theme set */
    open protected fun fullTheme() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val decorView = window.decorView
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            window.statusBarColor = Color.TRANSPARENT
        }
    }

    /** child activity override this fun to switch theme */
    open protected fun dealStatusBarDefault(): Boolean = true
}