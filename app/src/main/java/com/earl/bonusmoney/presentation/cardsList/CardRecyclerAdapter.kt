package com.earl.bonusmoney.presentation.cardsList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.earl.bonusmoney.R
import com.earl.bonusmoney.databinding.CardRecyclerItemBinding
import com.earl.bonusmoney.presentation.models.CardRecyclerDetails

interface OnCardCompanyClickListener {
    fun onCardClicked(companyId: String, btnDetails: String)
}

class CardRecyclerAdapter(
    private val clickListener: OnCardCompanyClickListener
) : ListAdapter<CardRecyclerDetails, CardRecyclerAdapter.ItemViewHolder>(Diff) {

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
            item.provideRecyclerDetails(
                binding.bonusMoney,
                binding.logo,
                binding.cashbackPercent,
                binding.level,
                binding.scoreCount,
                binding.scoreText,
                binding.iconEye,
                binding.detailsBtn,
                binding.iconTrash,
                binding.layout
            )
            binding.detailsBtn.setOnClickListener {
                clickListener.onCardClicked(context.resources.getString(R.string.card_details_btn), item.provideId())
            }
            binding.iconEye.setOnClickListener {
                clickListener.onCardClicked(context.resources.getString(R.string.card_eye_btn), item.provideId())
            }
            binding.iconTrash.setOnClickListener {
                clickListener.onCardClicked(context.resources.getString(R.string.card_trash_btn), item.provideId())
            }
        }
    }

    companion object Diff : DiffUtil.ItemCallback<CardRecyclerDetails>() {
        override fun areItemsTheSame(oldItem: CardRecyclerDetails, newItem: CardRecyclerDetails) = oldItem.isSame(newItem)
        override fun areContentsTheSame(oldItem: CardRecyclerDetails, newItem: CardRecyclerDetails) = oldItem.equals(newItem)
    }
}