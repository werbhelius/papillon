package com.werb.papillon.widget.card

import android.view.View
import com.werb.library.MoreViewHolder
import com.werb.papillon.model.view.LeftMenu
import kotlinx.android.synthetic.main.layout_drawer_menu.*

/**
 * Created by wanbo on 2017/12/29.
 */
class LeftMenuViewHolder(containerView: View) : MoreViewHolder<LeftMenu>(containerView) {

    private val context = containerView.context

    override fun bindData(data: LeftMenu, payloads: List<Any>) {
        menuIcon.setBackgroundResource(data.resId)
        menuTitle.text = data.title
        if (data.select) {

        }
    }
}