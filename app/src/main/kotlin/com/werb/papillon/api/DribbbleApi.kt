package com.werb.papillon.api

import com.werb.papillon.model.OAuth
import com.werb.papillon.model.Token
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


/**
 * Created by wanbo on 2017/12/25.
 */
interface DribbbleApi {

    @POST("oauth/token")
    fun requestToken(@Body oAuth: OAuth): Call<Token>

}