package com.earl.bonusmoney.data.mappers

interface LoyaltyLevelDataToDomainMapper<T> {

    fun map(
        number: Int,
        name: String,
        requiredSum: Int,
        markToCash: Int,
        cashToMark: Int
    ) : T
}