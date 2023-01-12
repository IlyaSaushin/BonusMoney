package com.earl.bonusmoney.data.mappers

import com.earl.bonusmoney.data.models.LoyaltyLevelData

interface CustomerMarkParametersDataToDomainMapper <T> {

    fun map(
        loyaltyLevel: LoyaltyLevelData,
        mark: Int
    ) : T
}