package com.emmanuelguther.gridtolinear

import android.view.MenuItem
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GridToLinear {

    fun change(item: MenuItem) {
        isLinearLayoutManager = !isLinearLayoutManager
        setDataRepresentationIcon(item)
        setLayoutManager()
    }

    private fun setLayoutManager() {
        var scrollPosition = 0
        // If a layout manager has already been set, get current scroll position.
        if (rv.layoutManager != null) {
            scrollPosition = (rv.layoutManager as LinearLayoutManager)
                .findFirstCompletelyVisibleItemPosition()
        }

        when {
            isLinearLayoutManager -> {
                rv.removeItemDecoration(gridDecoration)
                rv.addItemDecoration(linearDecoration)
                rv.layoutManager = linearLayoutManager
            }
            else -> {
                rv.removeItemDecoration(linearDecoration)
                rv.addItemDecoration(gridDecoration)
                rv.layoutManager = gridLayoutManager
            }
        }
        rv.scrollToPosition(scrollPosition)
    }

    private fun setDataRepresentationIcon(item: MenuItem) {
        item.setIcon(
            if (isLinearLayoutManager)
                firstDrawableIc else secondDrawableIc
        )
    }

    fun build(
        activity: FragmentActivity,
        recyclerView: RecyclerView,
        gridRows:Int = 2,
        @DrawableRes firstDrawableIcon: Int,
        @DrawableRes secondDrawableIcon: Int,
        @DimenRes marginDimensionLinear: Int,
        @DimenRes marginDimensionGrid: Int
    ) {
        rv = recyclerView
        spanCount = gridRows
        firstDrawableIc = firstDrawableIcon
        secondDrawableIc = secondDrawableIcon
        marginDimensionLn = marginDimensionLinear
        marginDimensionGd = marginDimensionGrid
        linearLayoutManager = LinearLayoutManager(activity)
        gridLayoutManager = GridLayoutManager(activity, spanCount)

        setLayoutManager()
    }

    companion object {
        private var spanCount:Int = 0
        private lateinit var rv: RecyclerView
        var isLinearLayoutManager: Boolean = false
        private var firstDrawableIc: Int = 0
        private var secondDrawableIc: Int = 0
        private var marginDimensionLn: Int = 0
        private var marginDimensionGd: Int = 0
        private lateinit var linearLayoutManager: LinearLayoutManager
        private lateinit var gridLayoutManager: GridLayoutManager
        private val linearDecoration: RecyclerView.ItemDecoration by lazy {
            VerticalItemDecoration(
                marginDimensionLn
            )
        }
        private val gridDecoration: RecyclerView.ItemDecoration by lazy {
            GridSpacingItemDecoration(
                spanCount, marginDimensionGd
            )
        }
    }
}
