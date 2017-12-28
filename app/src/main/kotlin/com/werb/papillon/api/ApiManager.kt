package com.werb.papillon.api

import android.util.Log
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by wanbo on 2017/12/25.
 */
object ApiManager {

    // Register Application key
    const val CLIENT_ID = "cb581ae8f91f8bec58ac43e939e60a2e381a69b8573ba417c749b22fffc4b609"
    const val CLIENT_SECRET = "36de32ae5f38bb564d8c4fab1c2619a2994714b153a7cfd35b5b2aeadc32f036"
    const val CALLBACK_URL = "papillon://authorization-callback"

    // Api host
    const val TOKEN_HOST = "https://dribbble.com/"
    private const val API_HOST = "https://api.dribbble.com/v1/"

    fun api(): DribbbleApi = create(HttpUrl.parse(API_HOST)!!)

    fun oauth(): DribbbleApi = create(HttpUrl.parse(TOKEN_HOST)!!)

    private fun create(httpUrl: HttpUrl): DribbbleApi {
        val logger = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
            Log.d("API", it)
        })
        logger.level = HttpLoggingInterceptor.Level.BASIC
        val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()
        return Retrofit.Builder()
                .baseUrl(httpUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(DribbbleApi::class.java)
    }

}