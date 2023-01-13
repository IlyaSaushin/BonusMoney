package com.earl.bonusmoney.data.mappers

import com.earl.bonusmoney.data.models.remote.LoyaltyLevel

interface CustomerMarkParametersRemoteToDataMapper<T> {

    fun map(
        loyaltyLevel: LoyaltyLevel,
        mark: Int
    ) : T
}