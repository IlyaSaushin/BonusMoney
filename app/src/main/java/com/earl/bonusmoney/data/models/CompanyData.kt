package com.earl.bonusmoney.data.models

import com.earl.bonusmoney.data.mappers.CompanyDataToDomainMapper

interface CompanyData {

    fun <T> map(mapper: CompanyDataToDomainMapper<T>) : T

    class Base(
        private val company: CompanyIdData,
        private val customerMarkParameters: CustomerMarkParametersData,
        private val mobileAppDashboard: MobileAppDashboardData
    ) : CompanyData {
        override fun <T> map(mapper: CompanyDataToDomainMapper<T>) =
            mapper.map(company, customerMarkParameters, mobileAppDashboard)
    }
}