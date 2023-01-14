package com.earl.bonusmoney.presentation.cardsList

import android.graphics.Canvas
import android.graphics.Rect
import android.util.Log
import android.view.View
import androidx.core.view.children
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val BOTTOM_MARGIN = 250

class PaginationLoadingDecoration : RecyclerView.ItemDecoration() {

    var showPaginationLoading = true
    private var isProgressVisible = false
    private var isListAlreadyFullyLoaded: Boolean = false
    private lateinit var currentRect: Rect

    override fun getItemOffsets(outRect: Rect, view: View, recyclerView: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, recyclerView, state)
        if (showPaginationLoading.not()) return
        currentRect = outRect
        when (isLastItem(recyclerView, view)) {
            true -> outRect.set(Rect(0, 0, 0, BOTTOM_MARGIN))
            else -> outRect.set(Rect(0, 0, 0, 0))
        }
    }

    fun markListAsFullyLoaded() {
        isListAlreadyFullyLoaded = true
    }

    private fun isLastItem(recyclerView: RecyclerView, view: View): Boolean {
        val lastItemPos = recyclerView.getChildAdapterPosition(view)
        return when(isListAlreadyFullyLoaded) {
            false -> lastItemPos == recyclerView.adapter!!.itemCount - 1
            else -> false
        }
    }

    override fun onDrawOver(canvas: Canvas, recyclerView: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(canvas, recyclerView, state)
        if (showPaginationLoading.not()) return

        val lastItem = recyclerView.children.lastOrNull()
        when (showLoading(recyclerView)) {
            true -> {
                PaginationProgressDrawer.drawSpinner(recyclerView, lastItem, canvas)
                isProgressVisible = true
            }
            else -> updateItems(recyclerView)
        }
    }

    private fun updateItems(recyclerView: RecyclerView) {
        recyclerView.children.lastOrNull()?.let {
            when (isLastItem(recyclerView, it)) {
                true -> it.measure(it.width, it.height)
                else -> if (isProgressVisible) {
                    isProgressVisible = false
                    recyclerView.invalidateItemDecorations()
                } else {
                    currentRect.set(Rect(0, 0, 0, 0))
                    recyclerView.invalidateItemDecorations()
                }
            }
        }
    }

    private fun showLoading(recyclerView: RecyclerView): Boolean {

        val layoutManager = recyclerView.layoutManager as LinearLayoutManager
        val lastVisibleItemPos = layoutManager.findLastCompletelyVisibleItemPosition()
        return when(isListAlreadyFullyLoaded) {
            false -> lastVisibleItemPos != -1 && lastVisibleItemPos >= recyclerView.adapter!!.itemCount - 1
            else -> false
        }
    }
}