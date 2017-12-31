package com.werb.papillon.ui.home

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.werb.papillon.MyApp
import com.werb.papillon.R

/** Created by wanbo <werbhelius@gmail.com> on 2017/9/5. */

class TabLayoutAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return if (position == 0) {
            FollowingFragment.newInstance()
        } else {
            ExploreFeedFragment.newInstance(MyApp.instance.resources.getStringArray(R.array.feed)[position])
        }
    }

    override fun getCount(): Int = MyApp.instance.resources.getStringArray(R.array.feed).size

    override fun getPageTitle(position: Int): CharSequence = MyApp.instance.resources.getStringArray(R.array.feed)[position]

}