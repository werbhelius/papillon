package com.werb.papillon.observer

import android.app.Activity
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import org.greenrobot.eventbus.EventBus

/**
 * Created by wanbo on 2017/12/31.
 */
class EventBusObserver(private val activity: Activity): LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun register(){
        EventBus.getDefault().register(activity)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun unRegister(){
        EventBus.getDefault().unregister(activity)
    }

}