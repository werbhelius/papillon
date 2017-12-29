package com.werb.papillon

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import com.werb.library.MoreType
import com.werb.library.link.RegisterItem
import com.werb.papillon.widget.card.LineViewHolder

/**
 * Created by wanbo on 2017/12/25.
 */
class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        Fresco.initialize(this)
        initMoreViewType()
    }

    private fun initMoreViewType() {
        MoreType.soleRegister(
                RegisterItem(R.layout.layout_view_line, LineViewHolder::class.java))
    }

    companion object {
        lateinit var instance: MyApp
    }

}