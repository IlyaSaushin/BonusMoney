package com.earl.bonusmoney.domain.mappers

import com.earl.bonusmoney.domain.models.CompanyIdDomain
import com.earl.bonusmoney.domain.models.CustomerMarkParametersDomain
import com.earl.bonusmoney.domain.models.MobileAppDashboardDomain

interface CompanyDomainToPresentationMapper<T> {

    fun map(
        company: CompanyIdDomain,
        customerMarkParameters: CustomerMarkParametersDomain,
        mobileAppDashboard: MobileAppDashboardDomain
    ) : T
}