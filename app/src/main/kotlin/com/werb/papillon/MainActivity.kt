package com.werb.papillon

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBarDrawerToggle
import com.werb.papillon.extension.string
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.widget_view_search.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
    }

    private fun initUI() {
        setSupportActionBar(searchToolbar)
        searchToolbar.title = string(R.string.app_name)
        val toggle = ActionBarDrawerToggle(this, mainDrawerLayout, searchToolbar, R.string.open, R.string.close)
        mainDrawerLayout.setDrawerListener(toggle)
        toggle.syncState()
    }

    companion object {
        fun startActivity(activity: Activity) {
            val intent = Intent(activity, MainActivity::class.java)
            activity.startActivity(intent)
            activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            activity.finish()
        }
    }
}
