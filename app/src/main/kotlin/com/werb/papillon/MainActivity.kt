package com.werb.papillon

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import com.werb.papillon.event.MenuSelectEvent
import com.werb.papillon.extension.string
import com.werb.papillon.observer.EventBusObserver
import com.werb.papillon.persistence.OAuthUserViewModel
import com.werb.papillon.repository.UserRepository
import com.werb.papillon.ui.explore.FeedFragment
import com.werb.papillon.ui.home.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.widget_view_search.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity : AppCompatActivity() {

    private lateinit var oauthUserViewModel: OAuthUserViewModel
    private var currentFragment: Fragment? = null
    private val fragments: List<Fragment> by lazy { getFragments() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
        subscribeUI()
        lifecycle.addObserver(EventBusObserver(this))
    }

    private fun initUI() {
        // toolbar
        supportActionBar?.setDisplayShowTitleEnabled(false)
        toolbarTitle.text = string(R.string.app_name)
        searchToolbar.inflateMenu(R.menu.toolbar_search)
        val toggle = ActionBarDrawerToggle(this, mainDrawerLayout, searchToolbar, R.string.open, R.string.close)
        mainDrawerLayout.setDrawerListener(toggle)
        toggle.syncState()
        // page
        addFragment(fragments[0])

    }

    private fun subscribeUI() {
        oauthUserViewModel = ViewModelProviders.of(this, OAuthUserViewModel.Factory(UserRepository())).get(OAuthUserViewModel::class.java)
        oauthUserViewModel.oaothUser?.observe(this, Observer { user ->
            user?.let {
                menuList.buildMenu(it)
            }
        })
    }

    private fun getFragments(): ArrayList<Fragment> {
        return arrayListOf<Fragment>().apply {
            add(HomeFragment.newInstance())
            add(FeedFragment.newInstance())
        }
    }

    private fun addFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        if (supportFragmentManager.findFragmentByTag(fragment::class.java.simpleName) == null) {
            transaction.add(R.id.contentLayout, fragment, fragment::class.java.simpleName)
        }
        if (currentFragment != null) {
            transaction.hide(currentFragment)
        }
        transaction.show(fragment)
        transaction.commitAllowingStateLoss()
        currentFragment = fragment
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun menuEvent(event: MenuSelectEvent) {
        if (event.position > fragments.size) return
        addFragment(fragments[event.position])
        mainDrawerLayout.closeDrawer(GravityCompat.START)
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
