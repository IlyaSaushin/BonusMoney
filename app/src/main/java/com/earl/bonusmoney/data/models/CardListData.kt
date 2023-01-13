package com.earl.bonusmoney.data.models

import com.earl.bonusmoney.data.mappers.CardListDataToDomainMapper

sealed class CardListData {

    abstract fun <T> mapToDomain(mapper: CardListDataToDomainMapper<T>) : T

    data class Success(private val list: List<CompanyData>) : CardListData() {
        override fun <T> mapToDomain(mapper: CardListDataToDomainMapper<T>) =
            mapper.mapSuccess(list)
    }

    data class Fail(private val exception: Exception) : CardListData() {
        override fun <T> mapToDomain(mapper: CardListDataToDomainMapper<T>) =
            mapper.mapException(exception)
    }
}
