package com.earl.bonusmoney.data.mappers

import com.earl.bonusmoney.data.models.CompanyIdData
import com.earl.bonusmoney.data.models.CustomerMarkParametersData
import com.earl.bonusmoney.data.models.MobileAppDashboardData

interface CompanyDataToDomainMapper <T> {

    fun map(
        company: CompanyIdData,
        customerMarkParameters: CustomerMarkParametersData,
        mobileAppDashboard: MobileAppDashboardData
    ) : T
}