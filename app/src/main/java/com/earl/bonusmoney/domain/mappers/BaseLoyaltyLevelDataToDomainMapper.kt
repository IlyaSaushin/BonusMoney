package com.earl.bonusmoney.domain.mappers

import com.earl.bonusmoney.data.mappers.LoyaltyLevelDataToDomainMapper
import com.earl.bonusmoney.domain.models.LoyaltyLevelDomain
import javax.inject.Inject

class BaseLoyaltyLevelDataToDomainMapper @Inject constructor() : LoyaltyLevelDataToDomainMapper<LoyaltyLevelDomain> {

    override fun map(
        number: Int,
        name: String,
        requiredSum: Int,
        markToCash: Int,
        cashToMark: Int
    ) = LoyaltyLevelDomain.Base(number, name, requiredSum, markToCash, cashToMark)
}