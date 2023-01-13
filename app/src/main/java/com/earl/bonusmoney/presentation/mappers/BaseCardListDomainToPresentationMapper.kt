package com.earl.bonusmoney.presentation.mappers

import com.earl.bonusmoney.domain.mappers.CardListDomainToPresentationMapper
import com.earl.bonusmoney.domain.mappers.CompanyDomainToPresentationMapper
import com.earl.bonusmoney.domain.models.CompanyDomain
import com.earl.bonusmoney.presentation.models.CardListPresentation
import com.earl.bonusmoney.presentation.models.CompanyPresentation
import javax.inject.Inject

class BaseCardListDomainToPresentationMapper @Inject constructor(
    private val mapper: CompanyDomainToPresentationMapper<CompanyPresentation>
) : CardListDomainToPresentationMapper<CardListPresentation> {

    override fun mapSuccess(list: List<CompanyDomain>) =
        CardListPresentation.Success(list.map { it.mapToPresentation(mapper) })

    override fun mapFail(exception: Exception) =
        CardListPresentation.Fail(exception)
}