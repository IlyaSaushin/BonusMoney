package com.earl.bonusmoney.presentation.cardsList

interface CardLoadingResultListenerCallback {
    fun notifyUserAboutError(errorMessage: String)
    fun gotEmptyList()
}