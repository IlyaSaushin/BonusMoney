package com.earl.bonusmoney.data.mappers

import com.earl.bonusmoney.data.models.CompanyIdData
import javax.inject.Inject

class BaseCompanyIdRemoteToDataMapper @Inject constructor() : CompanyIdRemoteToDataMapper<CompanyIdData> {

    override fun map(id: String) = CompanyIdData(id)
}