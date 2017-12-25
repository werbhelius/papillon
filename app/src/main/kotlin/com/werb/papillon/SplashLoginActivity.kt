package com.werb.papillon

import android.os.Bundle
import com.werb.papillon.ui.BaseActivity

/**
 * Splash and login
 * Created by wanbo on 2017/12/25.
 */
class SplashLoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

}