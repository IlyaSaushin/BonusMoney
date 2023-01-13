package com.earl.bonusmoney.data.mappers

import com.earl.bonusmoney.data.models.remote.CompanyId
import com.earl.bonusmoney.data.models.remote.CustomerMarkParameters
import com.earl.bonusmoney.data.models.remote.MobileAppDashboard

interface CompanyRemoteToDataMapper<T> {

    fun map(
        company: CompanyId,
        customerMarkParameters: CustomerMarkParameters,
        mobileAppDashboardRemote: MobileAppDashboard
    ) : T
}