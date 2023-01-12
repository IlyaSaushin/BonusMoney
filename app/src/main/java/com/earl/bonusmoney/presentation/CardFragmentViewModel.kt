package com.earl.bonusmoney.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.earl.bonusmoney.domain.Interactor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardFragmentViewModel @Inject constructor(
    private val interactor: Interactor
) : ViewModel() {

    fun getAllCards() {
        viewModelScope.launch(Dispatchers.IO) {
            interactor.getAllCards()
        }
    }
}