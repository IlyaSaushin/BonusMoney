package com.earl.bonusmoney.domain.mappers

interface LoyaltyLevelDomainToPresentationMapper<T> {

    fun map(
        number: Int,
        name: String,
        requiredSum: Int,
        markToCash: Int,
        cashToMark: Int
    ) : T
}