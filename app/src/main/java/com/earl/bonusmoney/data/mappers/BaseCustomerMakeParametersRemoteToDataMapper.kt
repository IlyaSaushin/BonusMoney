package com.earl.bonusmoney.data.mappers

import com.earl.bonusmoney.data.models.CustomerMarkParametersData
import com.earl.bonusmoney.data.models.LoyaltyLevelData
import com.earl.bonusmoney.data.models.remote.LoyaltyLevelRemote
import javax.inject.Inject

class BaseCustomerMakeParametersRemoteToDataMapper @Inject constructor(
    private val mapper: LoyaltyLevelRemoteToDataMapper<LoyaltyLevelData>
) : CustomerMarkParametersRemoteToDataMapper<CustomerMarkParametersData> {

    override fun map(loyaltyLevel: LoyaltyLevelRemote, mark: Int) =
        CustomerMarkParametersData(loyaltyLevel.mapToData(mapper), mark)
}