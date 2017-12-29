package com.werb.papillon.persistence

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.werb.papillon.model.data.User
import com.werb.papillon.repository.UserRepository

/**
 * Created by wanbo on 2017/12/26.
 */
class OAuthUserViewModel(private val userRepository: UserRepository) : ViewModel() {

    var oaothUser: LiveData<User>? = userRepository.oauthUser()
        private set

    var loading: LiveData<Boolean> = userRepository.loading()
        private set

    fun requestOAuthUser() = userRepository.requestOAuthUser()

    class Factory(private val userRepository: UserRepository) : ViewModelProvider.NewInstanceFactory() {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
                OAuthUserViewModel(userRepository) as T
    }

}