package com.earl.bonusmoney.domain.mappers

import com.earl.bonusmoney.data.mappers.CompanyDataToDomainMapper
import com.earl.bonusmoney.data.mappers.CompanyIdDataToDomainMapper
import com.earl.bonusmoney.data.mappers.CustomerMarkParametersDataToDomainMapper
import com.earl.bonusmoney.data.mappers.MobileAppDashboardDataToDomainMapper
import com.earl.bonusmoney.data.models.CompanyIdData
import com.earl.bonusmoney.data.models.CustomerMarkParametersData
import com.earl.bonusmoney.data.models.MobileAppDashboardData
import com.earl.bonusmoney.domain.models.CompanyDomain
import com.earl.bonusmoney.domain.models.CompanyIdDomain
import com.earl.bonusmoney.domain.models.CustomerMarkParametersDomain
import com.earl.bonusmoney.domain.models.MobileAppDashboardDomain
import javax.inject.Inject

class BaseCompanyDataToDomainMapper @Inject constructor(
    private val companyIdMapper: CompanyIdDataToDomainMapper<CompanyIdDomain>,
    private val customerMapper: CustomerMarkParametersDataToDomainMapper<CustomerMarkParametersDomain>,
    private val mobileAppMapper: MobileAppDashboardDataToDomainMapper<MobileAppDashboardDomain>
) : CompanyDataToDomainMapper<CompanyDomain> {

    override fun map(
        company: CompanyIdData,
        customerMarkParameters: CustomerMarkParametersData,
        mobileAppDashboard: MobileAppDashboardData
    ) = CompanyDomain.Base(
        company.mapToDomain(companyIdMapper),
        customerMarkParameters.mapToDomain(customerMapper),
        mobileAppDashboard.mapToDomain(mobileAppMapper)
    )
}