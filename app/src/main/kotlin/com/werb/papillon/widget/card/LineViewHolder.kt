package com.werb.papillon.widget.card

import android.view.View
import android.widget.LinearLayout
import com.werb.library.MoreViewHolder
import com.werb.papillon.model.view.Line
import kotlinx.android.synthetic.main.layout_view_line.*

/**
 * Created by wanbo on 2017/9/29.
 */
class LineViewHolder(containerView: View) : MoreViewHolder<Line>(containerView) {

    override fun bindData(data: Line, payloads: List<Any>) {
        val params = line.layoutParams as LinearLayout.LayoutParams
        params.height = data.height
        params.topMargin = data.margin
        params.bottomMargin = data.margin
    }
}