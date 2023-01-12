package com.earl.bonusmoney.domain.models

import com.earl.bonusmoney.domain.mappers.CustomerMarkParametersDomainToPresentationMapper

data class CustomerMarkParametersDomain(
    private val loyaltyLevel: LoyaltyLevelDomain,
    private val mark: Int
) {
    fun <T> mapToPresentation(mapper: CustomerMarkParametersDomainToPresentationMapper<T>) =
        mapper.map(loyaltyLevel, mark)
}