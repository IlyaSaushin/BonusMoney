package com.earl.bonusmoney.presentation.mappers

import com.earl.bonusmoney.domain.mappers.CustomerMarkParametersDomainToPresentationMapper
import com.earl.bonusmoney.domain.mappers.LoyaltyLevelDomainToPresentationMapper
import com.earl.bonusmoney.domain.models.LoyaltyLevelDomain
import com.earl.bonusmoney.presentation.models.CustomerMarkParametersPresentation
import com.earl.bonusmoney.presentation.models.LoyaltyLevelPresentation
import javax.inject.Inject

class BaseCustomerMarkParametersDomainToPresentationMapper @Inject constructor(
    private val loyaltyLevelMapper: LoyaltyLevelDomainToPresentationMapper<LoyaltyLevelPresentation>
) : CustomerMarkParametersDomainToPresentationMapper<CustomerMarkParametersPresentation> {

    override fun map(
        loyaltyLevel: LoyaltyLevelDomain,
        mark: Int
    ) = CustomerMarkParametersPresentation(
        loyaltyLevel.mapToPresentation(loyaltyLevelMapper),
        mark
    )
}