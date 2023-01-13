package com.earl.bonusmoney.presentation

interface CardLoadingResultListenerCallback {
    fun notifyUserAboutError(errorMessage: String)
    fun gotEmptyList()
}