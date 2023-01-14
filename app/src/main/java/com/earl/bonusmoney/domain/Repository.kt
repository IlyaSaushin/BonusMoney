package com.earl.bonusmoney.domain

import com.earl.bonusmoney.domain.models.CardListDomain

interface Repository {

    suspend fun getAllCards(offset: Int, apikey: Map<String, String>) : CardListDomain

    suspend fun getAllCardsIdeal(offset: Int, apikey: Map<String, String>) : CardListDomain

    suspend fun getAllCardsLong(offset: Int, apikey: Map<String, String>) : CardListDomain

    suspend fun getAllCardsError(offset: Int, apikey: Map<String, String>) : CardListDomain
}