package com.werb.papillon.widget.card

import android.text.Html
import android.view.View
import com.werb.library.MoreViewHolder
import com.werb.papillon.model.data.User
import kotlinx.android.synthetic.main.layout_drawer_header.*

/**
 * Created by wanbo on 2017/12/29.
 */
class LeftHeaderViewHolder(containerView: View) : MoreViewHolder<User>(containerView) {

    override fun bindData(data: User, payloads: List<Any>) {
        avatar.setImageURI(data.avatar_url)
        name.text = data.name
        bio.text = Html.fromHtml(data.bio)
    }
}