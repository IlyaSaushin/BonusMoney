package com.earl.bonusmoney.domain.models

import com.earl.bonusmoney.domain.mappers.LoyaltyLevelDomainToPresentationMapper

interface LoyaltyLevelDomain {

    fun <T> mapToPresentation(mapper: LoyaltyLevelDomainToPresentationMapper<T>) : T

    class Base(
        private val number: Int,
        private val name: String,
        private val requiredSum: Int,
        private val markToCash: Int,
        private val cashToMark: Int
    ) : LoyaltyLevelDomain {
        override fun <T> mapToPresentation(mapper: LoyaltyLevelDomainToPresentationMapper<T>) =
            mapper.map(number, name, requiredSum, markToCash, cashToMark)
    }
}