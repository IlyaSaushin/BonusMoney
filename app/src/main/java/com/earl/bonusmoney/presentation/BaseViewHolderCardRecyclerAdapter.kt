package com.earl.bonusmoney.presentation

import android.view.View
import androidx.recyclerview.widget.RecyclerView

interface OnItemClickListener<T> {
    fun click(item: T)
}

abstract class BaseViewHolder<T>(view: View) : RecyclerView.ViewHolder(view) {
    open fun bind(item: T) {}

    class Loading<T>(view: View) : BaseViewHolder<T>(view)

    abstract class Clickable<T>(
        view: View,
        private val listener: OnItemClickListener<T>
    ) : BaseViewHolder<T>(view) {
        override fun bind(item: T) {
            itemView.setOnClickListener {
                listener.click(item)
            }
        }
    }
}