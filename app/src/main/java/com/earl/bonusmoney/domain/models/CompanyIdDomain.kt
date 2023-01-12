package com.earl.bonusmoney.domain.models

import com.earl.bonusmoney.domain.mappers.CompanyIdDomainToPresentationMapper

data class CompanyIdDomain(
    private val id: String
) {
    fun <T> mapToPresentation(mapper: CompanyIdDomainToPresentationMapper<T>) =
        mapper.map(id)
}