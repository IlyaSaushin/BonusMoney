package com.earl.bonusmoney.data.mappers

import com.earl.bonusmoney.data.models.remote.LoyaltyLevelRemote

interface CustomerMarkParametersRemoteToDataMapper<T> {

    fun map(
        loyaltyLevel: LoyaltyLevelRemote,
        mark: Int
    ) : T
}