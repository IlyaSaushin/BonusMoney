package com.earl.bonusmoney.domain.models

import com.earl.bonusmoney.domain.mappers.CompanyDomainToPresentationMapper

interface CompanyDomain {

    fun <T> mapToPresentation(mapper: CompanyDomainToPresentationMapper<T>) : T

    class Base(
        private val company: CompanyIdDomain,
        private val customerMarkParameters: CustomerMarkParametersDomain,
        private val mobileAppDashboard: MobileAppDashboardDomain
    ) : CompanyDomain {
        override fun <T> mapToPresentation(mapper: CompanyDomainToPresentationMapper<T>) =
            mapper.map(company, customerMarkParameters, mobileAppDashboard)
    }
}