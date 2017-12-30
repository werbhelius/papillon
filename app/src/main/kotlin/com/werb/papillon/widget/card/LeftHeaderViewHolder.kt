package com.werb.papillon.widget.card

import android.graphics.Bitmap
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory
import android.text.Html
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.BitmapImageViewTarget
import com.werb.library.MoreViewHolder
import com.werb.papillon.model.data.User
import kotlinx.android.synthetic.main.layout_drawer_header.*


/**
 * Created by wanbo on 2017/12/29.
 */
class LeftHeaderViewHolder(containerView: View) : MoreViewHolder<User>(containerView) {

    override fun bindData(data: User, payloads: List<Any>) {
        name.text = data.name
        bio.text = Html.fromHtml(data.bio)
        Glide.with(containerView.context)
                .asBitmap().load(data.avatar_url).into(object : BitmapImageViewTarget(avatar) {
            override fun setResource(resource: Bitmap?) {
                val circularBitmapDrawable = RoundedBitmapDrawableFactory.create(containerView.resources, resource)
                circularBitmapDrawable.isCircular = true
                avatar.setImageDrawable(circularBitmapDrawable)
            }
        })
    }
}