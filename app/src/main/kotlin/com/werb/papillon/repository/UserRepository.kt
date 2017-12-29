package com.werb.papillon.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.werb.papillon.api.ApiManager
import com.werb.papillon.model.data.User
import com.werb.papillon.store.PreferencesStore
import com.werb.papillon.util.ToastUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Created by wanbo on 2017/12/25.
 */
class UserRepository : LoadingDataSource() {

    private var oauthUser: MutableLiveData<User> = MutableLiveData<User>().apply {
        value = PreferencesStore.user
    }

    fun oauthUser(): LiveData<User>? = oauthUser

    private fun saveOAuthUser(user: User){
        PreferencesStore.user = user
        this.oauthUser.value = user
    }

    fun loading(): LiveData<Boolean> = loading

    fun requestOAuthUser() {
        loading.value = true
        ApiManager.api()
                .oauthUser()
                .enqueue(object : Callback<User>{
                    override fun onFailure(call: Call<User>?, t: Throwable?) {
                        loading.value = false
                    }

                    override fun onResponse(call: Call<User>?, response: Response<User>?) {
                        response?.body()?.let {
                            saveOAuthUser(it)
                        } ?: response?.errorBody()?.let {
                            ToastUtils.show(it.string())
                        }
                        loading.value = false
                    }

                })
    }

}