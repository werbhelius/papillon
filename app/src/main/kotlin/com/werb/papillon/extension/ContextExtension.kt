package com.werb.papillon.extension

import android.content.Context
import android.graphics.drawable.Drawable

/**
 * Created by wanbo on 2017/12/28.
 */


fun Context.string(strId: Int) = resources.getString(strId)
fun Context.color(id: Int): Int = resources.getColor(id)
fun Context.drawable(id: Int): Drawable = resources.getDrawable(id)

fun Context.dp2px(dpValue: Int): Int = (dpValue * resources.displayMetrics.density + 0.5f).toInt()
