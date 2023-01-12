package com.earl.bonusmoney.data.models

import com.earl.bonusmoney.data.mappers.CompanyIdDataToDomainMapper
import com.earl.bonusmoney.domain.models.CompanyIdDomain

data class CompanyIdData(
    private val id: String
) {
    fun mapToDomain(mapper: CompanyIdDataToDomainMapper<CompanyIdDomain>) =
        mapper.map(id)
}