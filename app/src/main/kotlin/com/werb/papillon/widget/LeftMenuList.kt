package com.werb.papillon.widget

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.View
import com.werb.library.MoreAdapter
import com.werb.library.action.MoreClickListener
import com.werb.library.link.RegisterItem
import com.werb.papillon.R
import com.werb.papillon.event.MenuSelectEvent
import com.werb.papillon.extension.dp2px
import com.werb.papillon.extension.string
import com.werb.papillon.model.view.LeftMenu
import com.werb.papillon.model.data.User
import com.werb.papillon.model.view.Line
import com.werb.papillon.widget.card.LeftHeaderViewHolder
import com.werb.papillon.widget.card.LeftMenuViewHolder
import org.greenrobot.eventbus.EventBus

/**
 * Created by wanbo on 2017/12/29.
 */
class LeftMenuList : RecyclerView {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle)

    private val adapter = MoreAdapter()

    init {
        adapter.apply {
            userSoleRegister()
            register(RegisterItem(R.layout.layout_drawer_header, LeftHeaderViewHolder::class.java))
            register(RegisterItem(R.layout.layout_drawer_menu, LeftMenuViewHolder::class.java, object : MoreClickListener(){
                override fun onItemClick(view: View, position: Int) {
                    val menu = adapter.getData(position) as LeftMenu
                    checked(menu.title)
                }
            }))
            attachTo(this@LeftMenuList)
        }
    }

    fun buildMenu(user: User) {
        adapter.loadData(user)
        adapter.loadData(LeftMenu(R.drawable.svg_home, context.string(R.string.home)))
        adapter.loadData(LeftMenu(R.drawable.svg_explore, context.string(R.string.explore)))
        adapter.loadData(LeftMenu(R.drawable.svg_designer, context.string(R.string.designers)))
        adapter.loadData(LeftMenu(R.drawable.svg_buckets, context.string(R.string.buckets)))
        adapter.loadData(LeftMenu(R.drawable.svg_likes, context.string(R.string.likes)))
        adapter.loadData(LeftMenu(R.drawable.svg_shots, context.string(R.string.shots)))
        adapter.loadData(LeftMenu(R.drawable.svg_blog, context.string(R.string.blog)))
        adapter.loadData(Line(context.dp2px(1), context.dp2px(11)))
        adapter.loadData(LeftMenu(R.drawable.svg_setting, context.string(R.string.setting)))
        checked(context.string(R.string.home))
    }

    private fun checked(str: String) {
        adapter.list.filterIsInstance<LeftMenu>()
                .forEach {
                    it.select = it.title == str
                    if (it.title == str) {
                        EventBus.getDefault().post(MenuSelectEvent(adapter.getDataIndex(it) - 1))
                    }
                }
        adapter.notifyDataSetChanged()
    }

}