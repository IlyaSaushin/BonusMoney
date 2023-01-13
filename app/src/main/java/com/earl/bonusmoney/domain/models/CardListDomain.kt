package com.earl.bonusmoney.domain.models

import com.earl.bonusmoney.domain.mappers.CardListDomainToPresentationMapper

sealed class CardListDomain {

    abstract fun <T> mapToPresentation(mapper: CardListDomainToPresentationMapper<T>) : T

    data class Success(private val list: List<CompanyDomain>) : CardListDomain() {
        override fun <T> mapToPresentation(mapper: CardListDomainToPresentationMapper<T>) =
            mapper.mapSuccess(list)
    }

    data class Fail(private val exception: Exception) : CardListDomain() {
        override fun <T> mapToPresentation(mapper: CardListDomainToPresentationMapper<T>) =
            mapper.mapFail(exception)
    }

}
