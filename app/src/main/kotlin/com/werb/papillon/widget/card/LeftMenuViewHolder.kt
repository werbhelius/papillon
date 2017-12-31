package com.werb.papillon.widget.card

import android.graphics.PorterDuff
import android.view.View
import com.werb.library.MoreViewHolder
import com.werb.papillon.R
import com.werb.papillon.extension.color
import com.werb.papillon.extension.drawable
import com.werb.papillon.model.view.LeftMenu
import kotlinx.android.synthetic.main.layout_drawer_menu.*

/**
 * Created by wanbo on 2017/12/29.
 */
class LeftMenuViewHolder(containerView: View) : MoreViewHolder<LeftMenu>(containerView) {

    private val context = containerView.context

    override fun bindData(data: LeftMenu, payloads: List<Any>) {
        val icon = context.drawable(data.resId)
        menuTitle.text = data.title
        if (data.select) {
            menuTitle.setTextColor(context.color(R.color.color_EA4C89))
            icon.setColorFilter(context.color(R.color.color_EA4C89), PorterDuff.Mode.SRC_IN)
        } else {
            menuTitle.setTextColor(context.color(R.color.color_FFFFFF))
            icon.setColorFilter(context.color(R.color.color_7F8187), PorterDuff.Mode.SRC_IN)
        }
        menuIcon.setBackgroundDrawable(icon)
        addOnClickListener(containerView)
    }
}