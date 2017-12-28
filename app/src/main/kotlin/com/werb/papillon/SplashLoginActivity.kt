package com.werb.papillon

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.Handler
import com.werb.papillon.model.OAuth
import com.werb.papillon.persistence.OAuthObserver
import com.werb.papillon.persistence.OAuthViewModel
import com.werb.papillon.persistence.TokenViewModel
import com.werb.papillon.repository.TokenRepository
import com.werb.papillon.ui.BaseActivity
import com.werb.papillon.util.ToastUtils
import kotlinx.android.synthetic.main.activity_login.*

/**
 * Splash and login
 * Created by wanbo on 2017/12/25.
 */
class SplashLoginActivity : BaseActivity() {

    private lateinit var tokenViewModel: TokenViewModel
    private lateinit var oauthViewModel: OAuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initUI()
        subscribeUI()
        lifecycle.addObserver(OAuthObserver(intent, tokenViewModel))
    }

    private fun initUI() {
        loginButton.setOnClickListener {
            oauthViewModel.requestOAuth(OAuth())
        }
    }

    private fun toMain() {
        loginButton.text = "Welcome"
        Handler().postDelayed({
            MainActivity.startActivity(this)
        }, 1000)
    }

    private fun subscribeUI() {
        oauthViewModel = ViewModelProviders.of(this, OAuthViewModel.Factory()).get(OAuthViewModel::class.java)
        tokenViewModel = ViewModelProviders.of(this, TokenViewModel.Factory(TokenRepository())).get(TokenViewModel::class.java)
        tokenViewModel.token?.observe(this, Observer { token ->
            token?.let {
                toMain()
            } ?: ToastUtils.show("Token is null")
        })
        tokenViewModel.loading.observe(this, Observer { loading ->
            loading?.let {
                if (loading) {
                    ToastUtils.show("loading")
                } else {
                    ToastUtils.show("no loading")
                }
            }
        })
    }

}