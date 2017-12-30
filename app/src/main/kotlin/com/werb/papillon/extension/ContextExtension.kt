package com.werb.papillon.extension

import android.content.Context
import android.content.res.Configuration
import android.graphics.drawable.Drawable

/**
 * Created by wanbo on 2017/12/28.
 */


fun Context.string(strId: Int) = resources.getString(strId)
fun Context.color(id: Int): Int = resources.getColor(id)
fun Context.drawable(id: Int): Drawable = resources.getDrawable(id)

fun Context.dp2px(dpValue: Int): Int = (dpValue * resources.displayMetrics.density + 0.5f).toInt()

val Context.widthPixels: Int
    get() {
        val displayMetrics = resources.displayMetrics
        val cf = resources.configuration
        val ori = cf.orientation
        if (ori == Configuration.ORIENTATION_LANDSCAPE) {
            return displayMetrics.heightPixels
        } else if (ori == Configuration.ORIENTATION_PORTRAIT) {
            return displayMetrics.widthPixels
        }
        return 0
    }

val Context.heightPixels: Int
    get() {
        val displayMetrics = resources.displayMetrics
        val cf = resources.configuration
        val ori = cf.orientation
        if (ori == Configuration.ORIENTATION_LANDSCAPE) {
            return displayMetrics.widthPixels
        } else if (ori == Configuration.ORIENTATION_PORTRAIT) {
            return displayMetrics.heightPixels
        }
        return 0
    }
