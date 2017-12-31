package com.werb.papillon.ui.explore

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.werb.papillon.R
import com.werb.papillon.ui.home.TabLayoutAdapter
import kotlinx.android.synthetic.main.fragment_explore.*

/**
 * Created by wanbo on 2017/12/31.
 */
class FeedFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_explore, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        // tabLayout
        mainViewPager.offscreenPageLimit = 4
        mainViewPager.adapter = TabLayoutAdapter(activity?.supportFragmentManager)
        mainTabLayout.setupWithViewPager(mainViewPager)
    }

    companion object {

        fun newInstance(): FeedFragment = FeedFragment()
    }

}