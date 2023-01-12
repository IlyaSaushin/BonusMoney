package com.earl.bonusmoney.presentation.mappers

import com.earl.bonusmoney.domain.mappers.CompanyIdDomainToPresentationMapper
import com.earl.bonusmoney.presentation.models.CompanyIdPresentation
import javax.inject.Inject

class BaseCompanyIdDomainToPresentationMapper @Inject constructor() : CompanyIdDomainToPresentationMapper<CompanyIdPresentation> {

    override fun map(id: String) = CompanyIdPresentation(id)
}