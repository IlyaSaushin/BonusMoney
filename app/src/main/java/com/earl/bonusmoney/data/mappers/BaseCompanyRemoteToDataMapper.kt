package com.earl.bonusmoney.data.mappers

import com.earl.bonusmoney.data.models.CompanyData
import com.earl.bonusmoney.data.models.CompanyIdData
import com.earl.bonusmoney.data.models.CustomerMarkParametersData
import com.earl.bonusmoney.data.models.MobileAppDashboardData
import com.earl.bonusmoney.data.models.remote.CompanyId
import com.earl.bonusmoney.data.models.remote.CustomerMarkParameters
import com.earl.bonusmoney.data.models.remote.MobileAppDashboard
import javax.inject.Inject

class BaseCompanyRemoteToDataMapper @Inject constructor(
    private val companyIdMapper: CompanyIdRemoteToDataMapper<CompanyIdData>,
    private val customerMarkParametersRemoteToDataMapper: CustomerMarkParametersRemoteToDataMapper<CustomerMarkParametersData>,
    private val mobileAppDashboardRemoteToDataMapper: MobileAppDashboardRemoteToDataMapper<MobileAppDashboardData>
) : CompanyRemoteToDataMapper<CompanyData> {

    override fun map(
        company: CompanyId,
        customerMarkParameters: CustomerMarkParameters,
        mobileAppDashboardRemote: MobileAppDashboard
    ) = CompanyData.Base(
        company.mapToData(companyIdMapper),
        customerMarkParameters.mapToData(customerMarkParametersRemoteToDataMapper),
        mobileAppDashboardRemote.mapToData(mobileAppDashboardRemoteToDataMapper)
    )
}