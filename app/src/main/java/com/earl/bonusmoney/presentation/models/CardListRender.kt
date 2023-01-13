package com.earl.bonusmoney.presentation.models

import android.util.Log
import com.earl.bonusmoney.presentation.CardLoadingResultListenerCallback
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

interface CardListRender {

    fun updateCardList(list: List<CompanyPresentation>)

    fun provideException(e: Exception)

    fun provideCardFlow() : Flow<List<CardRecyclerDetails>>

    fun setErrorListenerCallback(callback: CardLoadingResultListenerCallback)

    class Base @Inject constructor() : CardListRender {

        private val cards: MutableStateFlow<List<CardRecyclerDetails>> = MutableStateFlow(emptyList())
        private var cardLoadingResultCallback: CardLoadingResultListenerCallback? = null

        override fun setErrorListenerCallback(callback: CardLoadingResultListenerCallback) {
            cardLoadingResultCallback = callback
        }

        override fun updateCardList(list: List<CompanyPresentation>) {
            if (list.isEmpty()) {
                Log.d("tag", "initRecyclerAdapter: empty list")
                cardLoadingResultCallback?.gotEmptyList()
            }
            cards.value += list.map { it.provideDetailsForCardRecycler() }
        }

        override fun provideCardFlow() = cards

        override fun provideException(e: Exception) {
            val errorMessage = when(e.message) {
                badRequestException -> badRequestException
                unauthorizedRequestException -> "ошибка авторизации"
                internalServerException -> "все упало"
                else -> "unknown error :_("
            }
            cardLoadingResultCallback?.notifyUserAboutError(errorMessage)
            cardLoadingResultCallback?.gotEmptyList()
        }
    }

    companion object {
        private const val badRequestException = "HTTP 400 Bad Request"
        private const val unauthorizedRequestException = "HTTP 401 Unauthorized"
        private const val internalServerException = "HTTP 500 Server Error"
    }
}