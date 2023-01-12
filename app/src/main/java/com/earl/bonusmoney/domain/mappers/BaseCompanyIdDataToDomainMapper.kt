package com.earl.bonusmoney.domain.mappers

import com.earl.bonusmoney.data.mappers.CompanyIdDataToDomainMapper
import com.earl.bonusmoney.domain.models.CompanyIdDomain
import javax.inject.Inject

class BaseCompanyIdDataToDomainMapper @Inject constructor() : CompanyIdDataToDomainMapper<CompanyIdDomain> {

    override fun map(id: String) = CompanyIdDomain(id)
}