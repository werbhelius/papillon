package com.werb.papillon.ui.home

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.werb.papillon.R
import com.werb.papillon.persistence.ShotsViewModel
import com.werb.papillon.repository.ShotsRepository

/**
 * Created by wanbo on 2017/12/29.
 */
class FeedFragment : Fragment() {

    private lateinit var shotsViewModel: ShotsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_feed, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        subscribeUI()
    }

    private fun subscribeUI() {
        if (!isAdded) return
        shotsViewModel = ViewModelProviders.of(this, ShotsViewModel.Factory(ShotsRepository(), arguments!!.getString("type"))).get(ShotsViewModel::class.java)
        shotsViewModel.shots.observe(this, Observer { shots ->

        })
        shotsViewModel.refresh()
    }

    companion object {

        fun newInstance(type: String): FeedFragment = FeedFragment().apply {
            val args = Bundle()
            args.putString("type", type)
            arguments = args
        }

    }

}