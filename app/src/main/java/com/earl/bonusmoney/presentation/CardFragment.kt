package com.earl.bonusmoney.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.earl.bonusmoney.R
import com.earl.bonusmoney.databinding.FragmentCardManagerBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CardFragment : BaseFragment<FragmentCardManagerBinding>() {

    private lateinit var viewModel: CardFragmentViewModel

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentCardManagerBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[CardFragmentViewModel::class.java]
        binding.cardManagement?.setOnClickListener{
            getAllCards()
        }
    }

    private fun getAllCards() {
        viewModel.getAllCards()
    }

    companion object {
        fun newInstance() = CardFragment()
    }
}