package com.earl.bonusmoney.domain

import com.earl.bonusmoney.domain.models.CardListDomain

interface Interactor {

    suspend fun getAllCards(offset: Int, apikey: Map<String, String>) : CardListDomain

    suspend fun getAllCardsIdeal(offset: Int, apikey: Map<String, String>) : CardListDomain

    suspend fun getAllCardsLong(offset: Int, apikey: Map<String, String>) : CardListDomain

    suspend fun getAllCardsError(offset: Int, apikey: Map<String, String>) : CardListDomain

    class Base(
        private val repository: Repository
    ) : Interactor {

        override suspend fun getAllCards(offset: Int, apikey: Map<String, String>) = repository.getAllCards(offset, apikey)

        override suspend fun getAllCardsIdeal(offset: Int, apikey: Map<String, String>) = repository.getAllCardsIdeal(offset, apikey)

        override suspend fun getAllCardsLong(offset: Int, apikey: Map<String, String>) = repository.getAllCardsLong(offset, apikey)

        override suspend fun getAllCardsError(offset: Int, apikey: Map<String, String>) = repository.getAllCardsError(offset, apikey)
    }
}