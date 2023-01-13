package com.earl.bonusmoney.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.earl.bonusmoney.domain.Interactor
import com.earl.bonusmoney.domain.mappers.CardListDomainToPresentationMapper
import com.earl.bonusmoney.presentation.models.CardListPresentation
import com.earl.bonusmoney.presentation.models.CardListRender
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CardFragmentViewModel @Inject constructor(
    private val interactor: Interactor,
    private val cardListRender: CardListRender,
    private val cardListDomainToPresentationMapper: CardListDomainToPresentationMapper<CardListPresentation>
) : ViewModel() {

    fun initCardLoadingErrorListener(callback: CardLoadingResultListenerCallback) {
        cardListRender.setErrorListenerCallback(callback)
    }

    fun getAllCards(offset: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val list = interactor.getAllCards(offset).mapToPresentation(cardListDomainToPresentationMapper)
            Log.d("tag", "getAllCards: viewmodel -> $list")
            withContext(Dispatchers.Main) {
                list.map(cardListRender)
            }
        }
    }

    fun getAllCardsIdeal(offset: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val list = interactor.getAllCardsIdeal(offset).mapToPresentation(cardListDomainToPresentationMapper)
            Log.d("tag", "getAllCards: viewmodel -> $list")
            withContext(Dispatchers.Main) {
                list.map(cardListRender)
            }
        }
    }

    fun getAllCardsLong(offset: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val list = interactor.getAllCardsLong(offset).mapToPresentation(cardListDomainToPresentationMapper)
            Log.d("tag", "getAllCards: viewmodel -> $list")
            withContext(Dispatchers.Main) {
                list.map(cardListRender)
            }
        }
    }

    fun getAllCardsError(offset: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val list = interactor.getAllCardsError(offset).mapToPresentation(cardListDomainToPresentationMapper)
            Log.d("tag", "getAllCards: viewmodel -> $list")
            withContext(Dispatchers.Main) {
                list.map(cardListRender)
            }
        }
    }

    fun provideCardsFlow() = cardListRender.provideCardFlow()
}