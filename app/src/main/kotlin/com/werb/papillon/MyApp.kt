package com.werb.papillon

import android.app.Application

/**
 * Created by wanbo on 2017/12/25.
 */
class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: MyApp
    }

}