package com.werb.papillon.api

import com.werb.papillon.model.data.OAuth
import com.werb.papillon.model.data.Token
import com.werb.papillon.model.data.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


/**
 * Created by wanbo on 2017/12/25.
 */
interface Api {

    @POST("oauth/token")
    fun requestToken(@Body oAuth: OAuth): Call<Token>

    @GET("user")
    fun oauthUser(): Call<User>

}