package com.werb.papillon.api

import com.werb.papillon.store.PreferencesStore
import okhttp3.Interceptor
import okhttp3.Response


/**
 * Custom Interceptor
 * Created by wanbo on 2017/12/29.
 */
class UnauthorisedInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain?): Response? {
        val response = chain?.proceed(chain.request())
        if (response?.code() == 401) {
            //  TODO: 401 check and send EventBus
        }
        return response
    }
}

class HeaderInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain?): Response? {
        chain?.let {
            val build = chain.request().newBuilder().addHeader("Authorization", "Bearer ${PreferencesStore.token?.access_token}").build()
            return chain.proceed(build)
        } ?: return null
    }

}

