package com.werb.papillon.util

import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.werb.papillon.R

/**
 * Created by wanbo on 2017/12/30.
 */
object GlideHelper {

    /** Image load logic */
    fun imageLoadOption(): RequestOptions {
        return RequestOptions()
                .centerCrop()
                .placeholder(R.color.color_333333)
                .error(R.drawable.svg_icon_gary)
                .priority(Priority.LOW)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
    }

}