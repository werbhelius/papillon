package com.werb.papillon.ui.home

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.graphics.Rect
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.werb.library.MoreAdapter
import com.werb.library.link.RegisterItem
import com.werb.papillon.R
import com.werb.papillon.extension.dp2px
import com.werb.papillon.persistence.ShotsViewModel
import com.werb.papillon.repository.ShotsRepository
import com.werb.papillon.widget.card.GridFeedViewHolder
import com.werb.papillon.widget.diff.ShotsDiff
import kotlinx.android.synthetic.main.fragment_feed.*

/**
 * Created by wanbo on 2017/12/29.
 */
class FeedFragment : Fragment() {

    private lateinit var shotsViewModel: ShotsViewModel
    private val adapter = MoreAdapter()
    private var load = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_feed, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        subscribeUI()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        refresh.setColorSchemeResources(R.color.color_EA4C89)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
//        recyclerView.addItemDecoration(SpaceItemDecoration(context?.dp2px(4)))
        (recyclerView.itemAnimator as DefaultItemAnimator).supportsChangeAnimations = false
        adapter.apply {
            userSoleRegister()
            register(RegisterItem(R.layout.layout_view_grid_feed, GridFeedViewHolder::class.java))
            attachTo(recyclerView)
        }
        refresh.setOnRefreshListener {
            load = true
            shotsViewModel.refresh()
        }
    }

    private fun subscribeUI() {
        if (!isAdded) return
        shotsViewModel = ViewModelProviders.of(this, ShotsViewModel.Factory(ShotsRepository(), arguments!!.getString("type"))).get(ShotsViewModel::class.java)
        shotsViewModel.shots.observe(this, Observer { shots ->
            shots?.let {
                if (load) {
                    adapter.refresh(0, it, ShotsDiff::class.java)
                } else {
                    adapter.loadData(it)
                }
            }
        })
        shotsViewModel.loading.observe(this, Observer { loading ->
            if (!isHidden) {
                loading?.let {
                    refresh.isRefreshing = loading
                }
            }
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

    inner class SpaceItemDecoration(private val dex: Int?) : RecyclerView.ItemDecoration() {

        override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
            parent?.let {
                val position = parent.getChildLayoutPosition(view)
                if (position % 2 == 0) {
                    outRect?.right = dex
                } else {
                    outRect?.left = dex
                }
            }
        }

    }

}