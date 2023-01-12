package com.earl.bonusmoney.data.models

import com.earl.bonusmoney.data.mappers.CustomerMarkParametersDataToDomainMapper
import com.earl.bonusmoney.domain.models.CustomerMarkParametersDomain

data class CustomerMarkParametersData(
    private val loyaltyLevel: LoyaltyLevelData,
    private val mark: Int
) {
    fun mapToDomain(mapper: CustomerMarkParametersDataToDomainMapper<CustomerMarkParametersDomain>) =
        mapper.map(loyaltyLevel, mark)
}