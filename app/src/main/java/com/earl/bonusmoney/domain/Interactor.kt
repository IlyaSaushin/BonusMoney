package com.earl.bonusmoney.domain

import com.earl.bonusmoney.domain.models.CardListDomain

interface Interactor {

    suspend fun getAllCards(offset: Int) : CardListDomain

    suspend fun getAllCardsIdeal(offset: Int) : CardListDomain

    suspend fun getAllCardsLong(offset: Int) : CardListDomain

    suspend fun getAllCardsError(offset: Int) : CardListDomain

    class Base(
        private val repository: Repository
    ) : Interactor {

        override suspend fun getAllCards(offset: Int) = repository.getAllCards(offset)

        override suspend fun getAllCardsIdeal(offset: Int) = repository.getAllCardsIdeal(offset)

        override suspend fun getAllCardsLong(offset: Int) = repository.getAllCardsLong(offset)

        override suspend fun getAllCardsError(offset: Int) = repository.getAllCardsError(offset)
    }
}