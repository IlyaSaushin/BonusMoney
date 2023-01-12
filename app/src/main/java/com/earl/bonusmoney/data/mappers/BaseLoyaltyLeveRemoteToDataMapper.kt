package com.earl.bonusmoney.data.mappers

import com.earl.bonusmoney.data.models.LoyaltyLevelData
import javax.inject.Inject

class BaseLoyaltyLeveRemoteToDataMapper @Inject constructor() : LoyaltyLevelRemoteToDataMapper<LoyaltyLevelData> {

    override fun map(
        number: Int,
        name: String,
        requiredSum: Int,
        markToCash: Int,
        cashToMark: Int
    ) = LoyaltyLevelData.Base(
        number, name, requiredSum, markToCash, cashToMark
    )
}