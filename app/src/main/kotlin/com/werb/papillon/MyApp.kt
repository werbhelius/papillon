package com.werb.papillon

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

/**
 * Created by wanbo on 2017/12/25.
 */
class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        Fresco.initialize(this)
    }

    companion object {
        lateinit var instance: MyApp
    }

}