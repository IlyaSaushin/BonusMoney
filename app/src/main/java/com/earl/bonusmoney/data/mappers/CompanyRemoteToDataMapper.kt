package com.earl.bonusmoney.data.mappers

import com.earl.bonusmoney.data.models.remote.CompanyIdRemote
import com.earl.bonusmoney.data.models.remote.CustomerMarkParametersRemote
import com.earl.bonusmoney.data.models.remote.MobileAppDashboardRemote

interface CompanyRemoteToDataMapper<T> {

    fun map(
        company: CompanyIdRemote,
        customerMarkParametersRemote: CustomerMarkParametersRemote,
        mobileAppDashboardRemote: MobileAppDashboardRemote
    ) : T
}