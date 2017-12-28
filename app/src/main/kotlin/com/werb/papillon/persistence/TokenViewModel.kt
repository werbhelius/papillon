package com.werb.papillon.persistence

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.werb.papillon.model.OAuth
import com.werb.papillon.model.Token
import com.werb.papillon.repository.TokenRepository

/**
 * Created by wanbo on 2017/12/26.
 */
class TokenViewModel(private val tokenRepository: TokenRepository) : ViewModel() {

    var token: LiveData<Token>? = tokenRepository.localToken()
        private set

    var loading: LiveData<Boolean> = tokenRepository.loading()
        private set

    fun requestToken(oAuth: OAuth) = tokenRepository.requestToken(oAuth)

    class Factory(private val tokenRepository: TokenRepository) : ViewModelProvider.NewInstanceFactory() {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
                TokenViewModel(tokenRepository) as T
    }

}