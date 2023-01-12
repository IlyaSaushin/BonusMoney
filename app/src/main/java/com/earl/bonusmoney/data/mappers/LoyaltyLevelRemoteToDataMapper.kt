package com.earl.bonusmoney.data.mappers

interface LoyaltyLevelRemoteToDataMapper <T> {

    fun map(
        number: Int,
        name: String,
        requiredSum: Int,
        markToCash: Int,
        cashToMark: Int
    ) : T
}