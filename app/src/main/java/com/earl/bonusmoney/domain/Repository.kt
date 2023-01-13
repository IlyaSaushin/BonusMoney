package com.earl.bonusmoney.domain

import com.earl.bonusmoney.domain.models.CardListDomain

interface Repository {

    suspend fun getAllCards(offset: Int) : CardListDomain

    suspend fun getAllCardsIdeal(offset: Int) : CardListDomain

    suspend fun getAllCardsLong(offset: Int) : CardListDomain

    suspend fun getAllCardsError(offset: Int) : CardListDomain
}