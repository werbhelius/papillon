package com.werb.papillon.widget.card

import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions
import com.werb.library.MoreViewHolder
import com.werb.papillon.extension.dp2px
import com.werb.papillon.extension.widthPixels
import com.werb.papillon.model.data.Shot
import com.werb.papillon.util.GlideHelper
import kotlinx.android.synthetic.main.layout_view_grid_feed.*

/**
 * Created by wanbo on 2017/12/30.
 */
class GridFeedViewHolder(containerView: View) : MoreViewHolder<Shot>(containerView) {

    private val context = containerView.context

    init {
        val width = (context.widthPixels - context.dp2px(26)) / 2
        val height = width / 1.12
        card.layoutParams.width = width
        card.layoutParams.height = height.toInt()
    }

    override fun bindData(data: Shot, payloads: List<Any>) {
        Glide.with(containerView.context)
                .asBitmap()
                .load(data.images?.normal)
                .transition(BitmapTransitionOptions().crossFade())
                .apply(GlideHelper.imageLoadOption())
                .into(thumb)
        likeCount.text = data.likes_count.toString()
        commentCount.text = data.comments_count.toString()
        if (data.animated) {
            gif.visibility = View.VISIBLE
        } else {
            gif.visibility = View.GONE
        }
    }
}