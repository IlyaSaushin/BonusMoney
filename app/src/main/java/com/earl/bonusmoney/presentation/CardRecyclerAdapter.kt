package com.earl.bonusmoney.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.earl.bonusmoney.databinding.CardRecyclerItemBinding
import com.earl.bonusmoney.presentation.models.CardRecyclerDetails

class CardRecyclerAdapter : ListAdapter<CardRecyclerDetails, CardRecyclerAdapter.ItemViewHolder>(Diff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val bidning = CardRecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(bidning)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ItemViewHolder(private val binding: CardRecyclerItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CardRecyclerDetails) {
            val context = binding.bonusMoney.context
            Glide.with(context).load(item.image).into(binding.logo)
            binding.bonusMoney.text = item.name
            binding.cashbackPercent.text = item.cashbackPercent.toString()
            binding.level.text = item.loyaltyLevel
            // todo color!!!
        }
    }

    companion object Diff : DiffUtil.ItemCallback<CardRecyclerDetails>() {
        override fun areItemsTheSame(oldItem: CardRecyclerDetails, newItem: CardRecyclerDetails) = oldItem.isSame(newItem)
        override fun areContentsTheSame(oldItem: CardRecyclerDetails, newItem: CardRecyclerDetails) = oldItem.equals(newItem)
    }
}