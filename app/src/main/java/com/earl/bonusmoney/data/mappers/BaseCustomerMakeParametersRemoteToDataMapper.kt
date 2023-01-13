package com.earl.bonusmoney.data.mappers

import com.earl.bonusmoney.data.models.CustomerMarkParametersData
import com.earl.bonusmoney.data.models.LoyaltyLevelData
import com.earl.bonusmoney.data.models.remote.LoyaltyLevel
import javax.inject.Inject

class BaseCustomerMakeParametersRemoteToDataMapper @Inject constructor(
    private val mapper: LoyaltyLevelRemoteToDataMapper<LoyaltyLevelData>
) : CustomerMarkParametersRemoteToDataMapper<CustomerMarkParametersData> {

    override fun map(loyaltyLevel: LoyaltyLevel, mark: Int) =
        CustomerMarkParametersData(loyaltyLevel.mapToData(mapper), mark)
}