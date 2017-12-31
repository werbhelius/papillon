package com.werb.papillon.persistence

import android.arch.lifecycle.*
import android.content.Intent
import android.net.Uri
import android.util.Log
import com.werb.papillon.MyApp
import com.werb.papillon.api.ApiManager
import com.werb.papillon.model.data.OAuth

/**
 * Created by wanbo on 2017/12/28.
 */
class OAuthViewModel : ViewModel() {

    fun requestOAuth(oAuth: OAuth) {
        val intent = Intent()
        intent.action = "android.intent.action.VIEW"
        intent.data = Uri.parse("${ApiManager.TOKEN_HOST}${oAuth.oauthPath()}")
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        MyApp.instance.startActivity(intent)
    }

    class Factory: ViewModelProvider.NewInstanceFactory() {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
                OAuthViewModel() as T
    }

}