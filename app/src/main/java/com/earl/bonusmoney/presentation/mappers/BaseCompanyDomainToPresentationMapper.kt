package com.earl.bonusmoney.presentation.mappers

import com.earl.bonusmoney.domain.mappers.CompanyDomainToPresentationMapper
import com.earl.bonusmoney.domain.mappers.CompanyIdDomainToPresentationMapper
import com.earl.bonusmoney.domain.mappers.CustomerMarkParametersDomainToPresentationMapper
import com.earl.bonusmoney.domain.mappers.MobileAppDashboardDomainToPresentationMapper
import com.earl.bonusmoney.domain.models.CompanyIdDomain
import com.earl.bonusmoney.domain.models.CustomerMarkParametersDomain
import com.earl.bonusmoney.domain.models.MobileAppDashboardDomain
import com.earl.bonusmoney.presentation.models.CompanyIdPresentation
import com.earl.bonusmoney.presentation.models.CompanyPresentation
import com.earl.bonusmoney.presentation.models.CustomerMarkParametersPresentation
import com.earl.bonusmoney.presentation.models.MobileAppDashboardPresentation
import javax.inject.Inject

class BaseCompanyDomainToPresentationMapper @Inject constructor(
    private val companyIdMapper: CompanyIdDomainToPresentationMapper<CompanyIdPresentation>,
    private val customerMapper: CustomerMarkParametersDomainToPresentationMapper<CustomerMarkParametersPresentation>,
    private val mobileAppMapper: MobileAppDashboardDomainToPresentationMapper<MobileAppDashboardPresentation>
) : CompanyDomainToPresentationMapper<CompanyPresentation> {

    override fun map(
        company: CompanyIdDomain,
        customerMarkParameters: CustomerMarkParametersDomain,
        mobileAppDashboard: MobileAppDashboardDomain
    ) = CompanyPresentation.Base(
        company.mapToPresentation(companyIdMapper),
        customerMarkParameters.mapToPresentation(customerMapper),
        mobileAppDashboard.mapToPresentation(mobileAppMapper)
    )
}