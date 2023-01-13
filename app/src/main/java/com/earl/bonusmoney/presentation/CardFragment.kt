package com.earl.bonusmoney.presentation

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.earl.bonusmoney.R
import com.earl.bonusmoney.databinding.FragmentCardManagerBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class CardFragment : BaseFragment<FragmentCardManagerBinding>(), CardLoadingResultListenerCallback {

    private lateinit var viewModel: CardFragmentViewModel
    private var isLoading: Boolean = false
    private var cardsCount = EMPTY_LIST
    private lateinit var paginationLoadingDecoration: PaginationLoadingDecoration

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentCardManagerBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[CardFragmentViewModel::class.java]
        initProgressBar()
        initRecyclerAdapter()
        getAllCards(START_OFFSET_VALUE)
    }

    private fun initRecyclerAdapter() {
        val adapter = CardRecyclerAdapter()
        val recycler = binding.cardRecycler
        recycler.adapter = adapter
        paginationLoadingDecoration = PaginationLoadingDecoration()
        recycler.addItemDecoration(paginationLoadingDecoration)
        viewModel.initCardLoadingErrorListener(this)
        addScrollListener(binding.cardRecycler)
        lifecycleScope.launchWhenStarted {
            viewModel.provideCardsFlow()
                .onEach { cards ->
                    if (cards.isNotEmpty()) {
                        binding.progressLayout.isVisible = false
                    }
                    adapter.submitList(cards)
                }
                .collect()
        }
    }

    private fun addScrollListener(recycler: RecyclerView) {
        val recyclerLayoutManager = LinearLayoutManager(requireContext())
        recycler.layoutManager = recyclerLayoutManager
        val scrollListener: RecyclerView.OnScrollListener = object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val visibleItemCount = recycler.layoutManager?.childCount!!
                val totalItemsCount = recycler.layoutManager?.itemCount!!
                val firstVisibleItems = recyclerLayoutManager.findFirstVisibleItemPosition()
                if (!isLoading) {
                    if (visibleItemCount + firstVisibleItems >= totalItemsCount && totalItemsCount != cardsCount) {
                        isLoading = true
                        Log.d("tag", "onScrolled: load")
                        getAllCards(totalItemsCount)
                        cardsCount = totalItemsCount
                        Log.d("tag", "onScrolled: totals item count -> $totalItemsCount")
                        isLoading = false
                    }
                }
            }
        }
        recycler.addOnScrollListener(scrollListener)
    }

    private fun getAllCards(offset: Int) {
        viewModel.getAllCards(offset)
    }

    private fun initProgressBar() {
        binding.progressLayout.isVisible = cardsCount == 0
    }

    override fun notifyUserAboutError(errorMessage: String) {
        binding.progressLayout.isVisible = false
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Ошибочка вышла...")
        builder.setMessage(errorMessage)
        builder.setPositiveButton(R.string.okay) { dialog, which -> }
        builder.show()
    }

    override fun gotEmptyList() {
        paginationLoadingDecoration.markListAsFullyLoaded()
    }

    companion object {
        fun newInstance() = CardFragment()
        private const val START_OFFSET_VALUE = 0
        private const val EMPTY_LIST = 0
    }
}