package com.werb.papillon.api

import com.werb.papillon.model.data.OAuth
import com.werb.papillon.model.data.Shot
import com.werb.papillon.model.data.Token
import com.werb.papillon.model.data.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


/**
 * Created by wanbo on 2017/12/25.
 */
interface Api {

    @POST("oauth/token")
    fun requestToken(@Body oAuth: OAuth): Call<Token>

    @GET("user")
    fun oauthUser(): Call<User>

    @GET("shots")
    fun shots(@Query("sort") sort: String? = null,
              @Query("timeframe") timeframe: String? = null,
              @Query("page") page: Int,
              @Query("per_page") per_page: Int = 30): Call<List<Shot>>

    @GET("user/following/shots")
    fun followingShots(@Query("page") page: Int,
                       @Query("per_page") per_page: Int = 30): Call<List<Shot>>

}