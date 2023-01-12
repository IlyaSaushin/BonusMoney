package com.earl.bonusmoney.domain.mappers

import com.earl.bonusmoney.data.mappers.CustomerMarkParametersDataToDomainMapper
import com.earl.bonusmoney.data.mappers.LoyaltyLevelDataToDomainMapper
import com.earl.bonusmoney.data.models.LoyaltyLevelData
import com.earl.bonusmoney.domain.models.CustomerMarkParametersDomain
import com.earl.bonusmoney.domain.models.LoyaltyLevelDomain
import javax.inject.Inject

class BaseCustomerMarkParametersDataToDomainMapper @Inject constructor(
    private val mapper: LoyaltyLevelDataToDomainMapper<LoyaltyLevelDomain>
) : CustomerMarkParametersDataToDomainMapper<CustomerMarkParametersDomain> {

    override fun map(loyaltyLevel: LoyaltyLevelData, mark: Int) =
        CustomerMarkParametersDomain(loyaltyLevel.mapToDomain(mapper), mark)
}