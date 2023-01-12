package com.earl.bonusmoney.domain

interface Interactor {

    suspend fun getAllCards()

    class Base(
        private val repository: Repository
    ) : Interactor {
        override suspend fun getAllCards() {
            repository.getAllCards()
        }
    }
}