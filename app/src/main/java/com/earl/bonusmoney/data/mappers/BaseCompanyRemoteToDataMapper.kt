package com.earl.bonusmoney.data.mappers

import com.earl.bonusmoney.data.models.CompanyData
import com.earl.bonusmoney.data.models.CompanyIdData
import com.earl.bonusmoney.data.models.CustomerMarkParametersData
import com.earl.bonusmoney.data.models.MobileAppDashboardData
import com.earl.bonusmoney.data.models.remote.CompanyIdRemote
import com.earl.bonusmoney.data.models.remote.CustomerMarkParametersRemote
import com.earl.bonusmoney.data.models.remote.MobileAppDashboardRemote
import javax.inject.Inject

class BaseCompanyRemoteToDataMapper @Inject constructor(
    private val companyIdMapper: CompanyIdRemoteToDataMapper<CompanyIdData>,
    private val customerMarkParametersRemoteToDataMapper: CustomerMarkParametersRemoteToDataMapper<CustomerMarkParametersData>,
    private val mobileAppDashboardRemoteToDataMapper: MobileAppDashboardRemoteToDataMapper<MobileAppDashboardData>
) : CompanyRemoteToDataMapper<CompanyData> {

    override fun map(
        company: CompanyIdRemote,
        customerMarkParametersRemote: CustomerMarkParametersRemote,
        mobileAppDashboardRemote: MobileAppDashboardRemote
    ) = CompanyData.Base(
        company.mapToData(companyIdMapper),
        customerMarkParametersRemote.mapToData(customerMarkParametersRemoteToDataMapper),
        mobileAppDashboardRemote.mapToData(mobileAppDashboardRemoteToDataMapper)
    )
}