package com.werb.papillon.ui.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.werb.papillon.R
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by wanbo on 2018/1/1.
 */
class HomeFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        // tabLayout
        mainViewPager.offscreenPageLimit = 3
        mainViewPager.adapter = TabLayoutAdapter(activity?.supportFragmentManager)
        mainTabLayout.setupWithViewPager(mainViewPager)
    }

    companion object {

        fun newInstance(): HomeFragment = HomeFragment()
    }

}