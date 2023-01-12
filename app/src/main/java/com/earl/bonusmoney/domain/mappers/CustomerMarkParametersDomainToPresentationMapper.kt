package com.earl.bonusmoney.domain.mappers

import com.earl.bonusmoney.domain.models.LoyaltyLevelDomain

interface CustomerMarkParametersDomainToPresentationMapper<T> {

    fun map(
        loyaltyLevel: LoyaltyLevelDomain,
        mark: Int
    ) : T
}