package com.werb.papillon.model.data

import com.werb.papillon.api.ApiManager
import java.util.*

/**
 * Created by wanbo on 2017/12/25.
 */
data class Token(val access_token: String, val token_type: String, val scope: String)

class OAuth {

    private val client_id: String = ApiManager.CLIENT_ID
    private val client_secret: String = ApiManager.CLIENT_SECRET
    private val redirect_uri: String = ApiManager.CALLBACK_URL
    private val state: String = UUID.randomUUID().toString().substring(0, 4)
    private val scope: String = "public+write+comment+upload"
    var code: String? = null

    fun oauthPath(): String = "oauth/authorize?client_id=$client_id&redirect_uri=$redirect_uri&scope=$scope&state=$state"

}