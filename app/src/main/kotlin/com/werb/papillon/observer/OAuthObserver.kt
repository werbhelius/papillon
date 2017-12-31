package com.werb.papillon.observer

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.content.Intent
import android.util.Log
import com.werb.papillon.model.data.OAuth
import com.werb.papillon.persistence.TokenViewModel

/**
 * Created by wanbo on 2017/12/31.
 */
class OAuthObserver(private val intent: Intent, private val tokenViewModel: TokenViewModel) : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun requestToken() {
        intent.data?.let {
            val code = intent.data.getQueryParameter("code")
            Log.d("OAuthObserver", "code: $code")
            code?.let {
                tokenViewModel.requestToken(OAuth().apply {
                    this.code = code
                })
            }
        }
    }

}