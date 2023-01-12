package com.earl.bonusmoney.presentation.mappers

import com.earl.bonusmoney.domain.mappers.LoyaltyLevelDomainToPresentationMapper
import com.earl.bonusmoney.presentation.models.LoyaltyLevelPresentation
import javax.inject.Inject

class BaseLoyaltyLevelDomainToPresentationMapper @Inject constructor(): LoyaltyLevelDomainToPresentationMapper<LoyaltyLevelPresentation> {

    override fun map(
        number: Int,
        name: String,
        requiredSum: Int,
        markToCash: Int,
        cashToMark: Int
    ) = LoyaltyLevelPresentation.Base(
        number, name, requiredSum, markToCash, cashToMark
    )
}