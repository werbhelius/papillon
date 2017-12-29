package com.werb.papillon.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.werb.papillon.R
import com.werb.papillon.api.ApiManager
import com.werb.papillon.model.data.OAuth
import com.werb.papillon.model.data.Token
import com.werb.papillon.store.PreferencesStore
import com.werb.papillon.util.ToastUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Created by wanbo on 2017/12/25.
 */
class TokenRepository: LoadingDataSource() {

    private var token: MutableLiveData<Token> = MutableLiveData<Token>().apply {
        value = PreferencesStore.token
    }

    fun localToken(): LiveData<Token>? = token

    private fun saveToken(token: Token){
        PreferencesStore.token = token
        this.token.value = token
    }

    fun loading(): LiveData<Boolean> = loading

    fun requestToken(oAuth: OAuth) {
        loading.value = true
        ApiManager.oauth()
                .requestToken(oAuth)
                .enqueue(object : Callback<Token>{
                    override fun onFailure(call: Call<Token>?, t: Throwable?) {
                        ToastUtils.show(R.string.token_oauth_error)
                        loading.value = false
                    }

                    override fun onResponse(call: Call<Token>?, response: Response<Token>?) {
                        response?.body()?.let {
                            saveToken(it)
                        } ?: response?.errorBody()?.let {
                            ToastUtils.show(it.string())
                        }
                        loading.value = false
                    }

                })
    }

}